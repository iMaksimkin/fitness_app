package com.simbirsoft.fitness.service;

import com.simbirsoft.fitness.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getCards();
    Card getCard(Long id);
    Card saveCard(Card card);
    Card updateCard(Long id, Card card);
    void deleteCard(Long id);
}
