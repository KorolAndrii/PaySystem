package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.model.Payment;

import java.sql.Connection;

public interface PaymentDao extends Dao {
    Payment getById(Long id);

    long insertPayment(Payment payment);

    long deletePayment(Payment payment);

    long updatePayment(Payment payment);

    long insertPayment(Payment payment, Connection connection);
}
