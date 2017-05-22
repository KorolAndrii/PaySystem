package ua.korol.pay_system.persistence.model;

import java.sql.Timestamp;

public interface PaymentTemplate {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getRequisites();

    void setRequisites(String requisites);

    Boolean getState();

    void setState(Boolean state);

    Timestamp getRegularPaymentDate();

    void setRegularPaymentDate(Timestamp regularPaymentDate);

    Account getAccount();

    void setAccount(Account account);
}
