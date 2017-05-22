package ua.korol.pay_system.persistence.model.real;


import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.PaymentTemplate;

import java.sql.Timestamp;

public class PaymentTemplateImpl implements PaymentTemplate {
    private Long id;

    private String name;

    private String requisites;

    private Boolean state;

    private Timestamp regularPaymentDate;

    private Account account;

    public PaymentTemplateImpl() {
    }

    public PaymentTemplateImpl(Long id, String name, String requisites, Boolean state, Timestamp regularPaymentDate, AccountImpl account) {
        this.id = id;
        this.name = name;
        this.requisites = requisites;
        this.state = state;
        this.regularPaymentDate = regularPaymentDate;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRequisites() {
        return requisites;
    }

    @Override
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public Boolean getState() {
        return state;
    }

    @Override
    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public Timestamp getRegularPaymentDate() {
        return regularPaymentDate;
    }

    @Override
    public void setRegularPaymentDate(Timestamp regularPaymentDate) {
        this.regularPaymentDate = regularPaymentDate;
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
        return "PaymentTemplateImpl{" +
                "id=" + id +
                ", requisites='" + requisites + '\'' +
                ", state=" + state +
                ", regularPaymentDate=" + regularPaymentDate +
                ", account=" + account +
                '}';
    }
}
