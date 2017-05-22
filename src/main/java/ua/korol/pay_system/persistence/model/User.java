package ua.korol.pay_system.persistence.model;

import java.sql.Timestamp;

public interface User {
     long getId();

     void setId(long id);

     String getFirstName();

     void setFirstName(String firstName);

     String getSecondName();

     void setSecondName(String secondName);

     String getLastName();

     void setLastName(String lastName);

     String getEmail();

     void setEmail(String email);

     Timestamp getBirthday();

     void setBirthday(Timestamp birthday);

     String getMobilePhone();

     void setMobilePhone(String mobilePhone);

}
