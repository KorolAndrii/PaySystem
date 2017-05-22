package ua.korol.pay_system.persistence.model;

import java.util.List;

public interface Account {
    Long getId();

    void setId(Long id);

    Double getBalance();

    void setBalance(Double balance);

    User getUser();

    void setUser(User user);

    List<Card> getCards();

    List<Payment> getPayments();


    List<PaymentTemplate> getPaymentTemplates();

    void setCards(List<Card> cards);

    void setPayments(List<Payment> payments);


    void setPaymentTemplates(List<PaymentTemplate> paymentTemplates);
}
