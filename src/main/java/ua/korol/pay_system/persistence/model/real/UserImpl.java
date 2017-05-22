package ua.korol.pay_system.persistence.model.real;


import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.User;

import java.sql.Timestamp;

public class UserImpl implements User {
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String email;

    private Timestamp birthday;

    private String mobilePhone;

    private Account account;

    public UserImpl() {
    }

    public UserImpl(long id, String firstName, String middleName, String lastName,
                    String email, Timestamp birthday, String mobilePhone) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Timestamp getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", mobilePhone='" + mobilePhone + '}';
    }
}
