package ua.korol.pay_system.persistence.model.real;


import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.Card;

import java.sql.Timestamp;

public class CardImpl implements Card{
    private Long id;

    private String number;

    private Timestamp validity;

    private String cvv;

    private boolean status;

    private Double limit;

    private String pinCode;

    private Account account;

    private Double balance;

    public CardImpl() {
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
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public Timestamp getValidity() {
        return validity;
    }

    @Override
    public void setValidity(Timestamp validity) {
        this.validity = validity;
    }

    @Override
    public String getCvv() {
        return cvv;
    }

    @Override
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public Double getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Override
    public String getPinCode() {
        return pinCode;
    }

    @Override
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
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
    public String toString() {
        return "CardImpl{" +
                "id=" + id +
                ", number=" + number +
                ", validity=" + validity +
                ", cvv=" + cvv +
                ", status=" + status +
                ", limit=" + limit +
                ", pinCode=" + pinCode +
                ", account=" + account +
                ", balance=" + balance +
                '}';
    }
}
