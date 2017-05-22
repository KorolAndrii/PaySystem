package ua.korol.pay_system.persistence.model.real;

import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.Payment;

import java.sql.Timestamp;


public class PaymentImpl implements Payment {
    private Long id;

    private Timestamp payDate;

    private String address;

    private Double amount;

    private Account account;

    public PaymentImpl() {
    }

    public PaymentImpl(Long id, Timestamp payDate, String address,
                       Double amount, Account account) {
        this.id = id;
        this.payDate = payDate;
        this.address = address;
        this.amount = amount;
        this.account = account;
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
    public Timestamp getPayDate() {
        return payDate;
    }

    @Override
    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
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
    public String toString() {
        return "PaymentImpl{" +
                "id=" + id +
                ", payDate=" + payDate +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", account=" + account +
                '}';
    }
}
