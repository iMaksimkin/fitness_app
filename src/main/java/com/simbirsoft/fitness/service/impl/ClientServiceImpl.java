package com.simbirsoft.fitness.service.impl;

import com.simbirsoft.fitness.mapper.UserMapper;
import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.Workout;
import com.simbirsoft.fitness.model.enums.ClientStatus;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.repository.ClientRepository;
import com.simbirsoft.fitness.repository.WorkoutRepository;
import com.simbirsoft.fitness.service.CardService;
import com.simbirsoft.fitness.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final WorkoutRepository workoutRepository;
    private final UserMapper userMapper;
    private final CardService cardService;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClientsByStatus(ClientStatus status) {
        return clientRepository
                .findAll().stream()
                .filter(client -> client.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Client getClientByCard(Long id) {
        for (Client client : getClients()) {
            if (client.getCard().getId() == id)
                return client;
        }
        throw new RuntimeException();
    }

    @Override
    public Client saveClient(ClientDTO dto) {
        Client client = userMapper.clientDTOToClient(dto);
        client.setCard(cardService.saveCard(Card.builder().workoutAmount(0).lastVisitDay(LocalDateTime.now()).build()));
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, ClientDTO dto) {
        Client client = userMapper.clientDTOToClient(dto);
        client.setId(id);

        Long cardId = getClient(id).getCard().getId();
        cardService.updateCard(cardId, Card.builder().workoutAmount(dto.getCard().getWorkoutAmount()).build());
        return clientRepository.save(client);
    }

    @Override
    public Client clientVisit(Card card) {
        Client client = getClientByCard(card.getId());
        client.setStatus(ClientStatus.INSIDE);
        client.getCard().setWorkoutAmount(client.getCard().getWorkoutAmount()-1);
        client.getCard().setLastVisitDay(LocalDateTime.now());
        return clientRepository.save(client);
    }

    @Override
    public Client clientLeave(Long id) {
        Client client = getClient(id);
        client.setStatus(ClientStatus.OUTSIDE);
        return clientRepository.save(client);
    }

    @Override
    public Client clientWorkoutRemove(Long wid , Long cid) {
        Client client = getClient(cid);
        Workout workout = workoutRepository.getById(wid);
        client.getWorkouts().remove(workout);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
