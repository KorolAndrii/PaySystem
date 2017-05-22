package ua.korol.pay_system.persistence.model;


import java.sql.Timestamp;

public interface Payment {
    Long getId();

    void setId(Long id);

    Timestamp getPayDate();

    void setPayDate(Timestamp payDate);

    String getAddress();

    void setAddress(String address);

    Double getAmount();

    void setAmount(Double amount);

    Account getAccount();

    void setAccount(Account account);
}
