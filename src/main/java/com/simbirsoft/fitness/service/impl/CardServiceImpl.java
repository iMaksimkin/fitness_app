package com.simbirsoft.fitness.service.impl;

import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.repository.CardRepository;
import com.simbirsoft.fitness.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;


    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(Card.builder()
                .workoutAmount(card.getWorkoutAmount())
                .lastVisitDay(card.getLastVisitDay())
                .build());
    }

    @Override
    public Card updateCard(Long id, Card card) {
        Card currentCard = getCard(id);
        currentCard.setLastVisitDay(card.getLastVisitDay());
        currentCard.setWorkoutAmount(card.getWorkoutAmount());
        return cardRepository.save(currentCard);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
