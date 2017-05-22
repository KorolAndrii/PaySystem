package ua.korol.pay_system.service.impl;

import ua.korol.pay_system.persistence.dao.CardDao;
import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.service.CardService;

public class CardServiceImpl implements CardService {
    private CardDao cardDao;

    public CardServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public Card getCardById(Long id) {
        return cardDao.getById(id);
    }

    @Override
    public Card getCardByNumber(Integer id) {
        return cardDao.getByCardNumber(id);
    }

    @Override
    public long insertCard(Card card) {
        return cardDao.insertCard(card);
    }

    @Override
    public long deleteCard(Card card) {
        return cardDao.deleteCard(card);
    }

    @Override
    public long updateCard(Card card) {
        return cardDao.updateCard(card);
    }
}
