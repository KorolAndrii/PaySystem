package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.model.Card;

import java.sql.Connection;

public interface CardDao extends Dao {
    Card getById(Long id);

    Card getByCardNumber(Integer id);

    Card getByAccountId(Long id);

    long insertCard(Card card);

    long deleteCard(Card card);

    long updateCard(Card card);

    long updateCard(Card card, Connection connection);

    Card getCardByMajorities(boolean status);

    long updateBalanceByEmail(String email, Double amount, Connection connection);
}
