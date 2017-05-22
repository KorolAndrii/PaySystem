package ua.korol.pay_system.persistence.model.real;

import ua.korol.pay_system.persistence.model.*;

import java.util.List;

public class AccountImpl implements Account {
    private Long id;

    private Double balance;

    private User user;

    private List<Card> cards;

    private List<Payment> payments;

    private List<PaymentTemplate> paymentTemplates;

    public AccountImpl() {
    }

    public AccountImpl(Long id, Double balance, UserImpl user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public void setPaymentTemplates(List<PaymentTemplate> paymentTemplates) {
        this.paymentTemplates = paymentTemplates;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public List<PaymentTemplate> getPaymentTemplates() {
        return paymentTemplates;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", user=" + user +
                ", cards=" + cards +
                ", payments=" + payments +
                ", paymentTemplates=" + paymentTemplates +
                '}';
    }
}
