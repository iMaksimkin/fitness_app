package com.simbirsoft.fitness.service;

import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.enums.ClientStatus;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client getClient(Long id);
    List<Client> getClientsByStatus(ClientStatus status);
    Client getClientByCard(Long id);
    Client saveClient(ClientDTO client);
    Client updateClient(Long id, ClientDTO client);
    Client clientVisit(Card card);
    Client clientLeave(Long id);
    Client clientWorkoutRemove(Long wid , Long cid);
    void deleteClient(Long id);
}
