package ua.korol.pay_system.service.impl;

import ua.korol.pay_system.persistence.dao.CardDao;
import ua.korol.pay_system.persistence.dao.DaoFactory;
import ua.korol.pay_system.persistence.dao.DataSourceSingleton;
import ua.korol.pay_system.persistence.dao.PaymentDao;
import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.persistence.model.Payment;
import ua.korol.pay_system.persistence.model.real.PaymentImpl;
import ua.korol.pay_system.service.PaymentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class PaymentServiceImpl implements PaymentService {
    private PaymentDao paymentDao;
    private CardDao cardDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
        cardDao = DaoFactory.getCardDao();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getById(id);
    }

    @Override
    public long insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public long deletePayment(Payment payment) {
        return paymentDao.deletePayment(payment);
    }

    @Override
    public long updatePayment(Payment payment) {
        return paymentDao.updatePayment(payment);
    }

    @Override
    public boolean transferMoney(Card cardFrom, Card cardTo, double amount) {
        try (Connection connection = DataSourceSingleton.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            if ((cardFrom.getBalance() < amount) && cardFrom.isStatus() && cardTo.isStatus()) {
                throw new IllegalArgumentException();
            }
            double newAmountFrom = cardFrom.getBalance() - amount;
            double newAmountTo = cardTo.getBalance() + amount;

            cardFrom.setBalance(newAmountFrom);
            cardTo.setBalance(newAmountTo);

            cardDao.updateCard(cardFrom, connection);
            cardDao.updateCard(cardTo, connection);

            Payment paymentFrom = new PaymentImpl();
            paymentFrom.setAmount(amount);
            paymentFrom.setPayDate(new Timestamp(ZonedDateTime.now().toInstant().getEpochSecond() * 1000L));
            paymentFrom.setAddress(cardTo.getNumber());
            paymentFrom.setAccount(cardTo.getAccount());

            Payment paymentTo = new PaymentImpl();
            paymentTo.setAmount(amount);
            paymentTo.setPayDate(new Timestamp(ZonedDateTime.now().toInstant().getEpochSecond() * 1000L));
            paymentTo.setAddress(cardFrom.getNumber());
            paymentTo.setAccount(cardTo.getAccount());

            paymentDao.insertPayment(paymentFrom, connection);
            paymentDao.insertPayment(paymentTo, connection);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
