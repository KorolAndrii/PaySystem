package ua.korol.pay_system.persistence.model;

import java.sql.Timestamp;

public interface Card {
     Long getId();

     void setId(Long id);

     String getNumber();

     void setNumber(String number);

     Timestamp getValidity();

     void setValidity(Timestamp validity);

     String getCvv();

     void setCvv(String cvv);

     boolean isStatus();

     void setStatus(boolean status);

     Double getLimit();

     void setLimit(Double limit);

     String getPinCode();

     void setPinCode(String pinCode);

     Account getAccount();

     void setAccount(Account account);

     Double getBalance();

     void setBalance(Double balance);
}
