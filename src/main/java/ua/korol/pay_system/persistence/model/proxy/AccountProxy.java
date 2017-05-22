package ua.korol.pay_system.persistence.model.proxy;

import ua.korol.pay_system.persistence.model.*;
import ua.korol.pay_system.persistence.model.real.AccountImpl;
import ua.korol.pay_system.service.AccountService;
import ua.korol.pay_system.service.ServiceFactory;

import java.util.List;

public class AccountProxy implements Account {
    private Long id;

    private Account account;

    private AccountService accountService;

    public AccountProxy() {
    }

    public AccountProxy(Long id) {
        this.id = id;
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
        checkAccountForExist();
        return account.getBalance();
    }

    @Override
    public void setBalance(Double balance) {
        checkAccountForExist();
        account.setBalance(balance);
    }

    @Override
    public User getUser() {
        checkAccountForExist();
        return account.getUser();
    }

    @Override
    public void setUser(User user) {
        checkAccountForExist();
        account.setUser(user);
    }

    @Override
    public List<Card> getCards() {
        checkAccountForExist();
        return account.getCards();
    }

    @Override
    public List<Payment> getPayments() {
        checkAccountForExist();
        return account.getPayments();
    }

    @Override
    public List<PaymentTemplate> getPaymentTemplates() {
        checkAccountForExist();
        return account.getPaymentTemplates();
    }

    @Override
    public void setCards(List<Card> cards) {
        checkAccountForExist();
        account.setCards(cards);
    }

    @Override
    public void setPayments(List<Payment> payments) {
        checkAccountForExist();
        account.setPayments(payments);
    }

    @Override
    public void setPaymentTemplates(List<PaymentTemplate> paymentTemplates) {
        checkAccountForExist();
        account.setPaymentTemplates(paymentTemplates);
    }


    private void checkAccountForExist() {
        if (account == null) {
            accountService = ServiceFactory.getAccountService();
            account = downloadAccount();
        }
    }

    private AccountImpl downloadAccount() {
        return (AccountImpl) accountService.getAccountById(id);
    }

}
