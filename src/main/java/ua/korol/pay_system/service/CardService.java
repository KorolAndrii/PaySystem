package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.model.Card;

public interface CardService extends Service {
    Card getCardById(Long id);

    Card getCardByNumber(Integer id);

    long insertCard(Card card);

    long deleteCard(Card card);

    long updateCard(Card card);
}
