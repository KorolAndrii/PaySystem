package ua.korol.pay_system.persistence.model.proxy;

import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.persistence.model.real.CardImpl;
import ua.korol.pay_system.service.CardService;
import ua.korol.pay_system.service.ServiceFactory;

import java.sql.Timestamp;

public class CardProxy implements Card{
    private Long id;

    private Card card;

    private CardService cardService;

    public CardProxy() {
    }

    public CardProxy(Long id) {
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
    public String getNumber() {
        checkCardForExist();
        return card.getNumber();
    }

    @Override
    public void setNumber(String number) {
        checkCardForExist();
        card.setNumber(number);
    }

    @Override
    public Timestamp getValidity() {
        checkCardForExist();
        return card.getValidity();
    }

    @Override
    public void setValidity(Timestamp validity) {
        checkCardForExist();
        card.setValidity(validity);
    }

    @Override
    public String getCvv() {
        checkCardForExist();
        return card.getCvv();
    }

    @Override
    public void setCvv(String cvv) {
        checkCardForExist();
        card.setCvv(cvv);
    }

    @Override
    public boolean isStatus() {
        checkCardForExist();
        return card.isStatus();
    }

    @Override
    public void setStatus(boolean status) {
        checkCardForExist();
        card.setStatus(status);
    }

    @Override
    public Double getLimit() {
        checkCardForExist();
        return card.getLimit();
    }

    @Override
    public void setLimit(Double limit) {
        checkCardForExist();
        card.setLimit(limit);
    }

    @Override
    public String getPinCode() {
        checkCardForExist();
        return card.getPinCode();
    }

    @Override
    public void setPinCode(String pinCode) {
        checkCardForExist();
        card.setPinCode(pinCode);
    }

    @Override
    public Account getAccount() {
        checkCardForExist();
        return card.getAccount();
    }

    @Override
    public void setAccount(Account account) {
        checkCardForExist();
        card.setAccount(account);
    }

    @Override
    public Double getBalance() {
        checkCardForExist();
        return card.getBalance();
    }

    @Override
    public void setBalance(Double balance) {
        checkCardForExist();
        card.setBalance(balance);
    }

    private void checkCardForExist() {
        if (card == null) {
            cardService = ServiceFactory.getCardService();
            card = downloadCard();
        }
    }

    private CardImpl downloadCard() {
        return (CardImpl) cardService.getCardById(id);
    }
}
