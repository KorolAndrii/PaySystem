package ua.korol.pay_system.persistence.model.proxy;

import ua.korol.pay_system.persistence.model.User;
import ua.korol.pay_system.persistence.model.real.UserImpl;
import ua.korol.pay_system.service.ServiceFactory;
import ua.korol.pay_system.service.UserService;

import java.sql.Timestamp;

public class UserProxy implements User {
    // TODO: 21.03.2017 ROLE
    private Long id;

    private User user;

    private UserService userService;

    public UserProxy() {
    }

    public UserProxy(Long id) {
        this.id = id;
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
        checkUserForExist();
        return user.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        checkUserForExist();
        user.setFirstName(firstName);
    }

    @Override
    public String getSecondName() {
        checkUserForExist();
        return user.getSecondName();
    }

    @Override
    public void setSecondName(String secondName) {
        checkUserForExist();
        user.setSecondName(secondName);
    }

    @Override
    public String getLastName() {
        checkUserForExist();
        return user.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        checkUserForExist();
        user.setLastName(lastName);
    }

    @Override
    public String getEmail() {
        checkUserForExist();
        return user.getEmail();
    }

    @Override
    public void setEmail(String email) {
        checkUserForExist();
        user.setEmail(email);
    }

    @Override
    public Timestamp getBirthday() {
        checkUserForExist();
        return user.getBirthday();
    }

    @Override
    public void setBirthday(Timestamp birthday) {
        checkUserForExist();
        user.setBirthday(birthday);
    }

    @Override
    public String getMobilePhone() {
        checkUserForExist();
        return user.getMobilePhone();
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        checkUserForExist();
        user.setMobilePhone(mobilePhone);
    }

    private void checkUserForExist() {
        if (user == null) {
            userService = ServiceFactory.getUserService();
            user = downloadUser();
        }
    }

    private UserImpl downloadUser() {
        return (UserImpl) userService.getUserById(id);
    }

    @Override
    public String toString() {
        return "UserProxy{" +
                "user=" + user +
                '}';
    }
}
