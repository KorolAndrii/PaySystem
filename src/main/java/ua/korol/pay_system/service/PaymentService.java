package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.persistence.model.Payment;

public interface PaymentService extends Service {
    Payment getPaymentById(Long id);

    long insertPayment(Payment payment);

    long deletePayment(Payment payment);

    long updatePayment(Payment payment);

    boolean transferMoney(Card cardFrom, Card cardTo, double amount);
}
