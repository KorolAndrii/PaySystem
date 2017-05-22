package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.model.User;
import ua.korol.pay_system.persistence.model.real.UserImpl;
import ua.korol.pay_system.service.ServiceFactory;
import ua.korol.pay_system.service.UserService;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {

      /*  CardDao cardDao = DaoFactory.getCardDao();


        Card card1 = cardDao.getById(1l);
        Card card2 = cardDao.getById(2l);
       // card.setBalance(4124.51);
       // System.out.println(card);
       // cardDao.updateBalanceByEmail("sositehui", 444.0);
        PaymentService paymentService = new PaymentServiceImpl(DaoFactory.getPaymentDao());
        paymentService.transferMoney(card1, card2, 2000.0);*/

        // TODO: 08.04.2017 как сделать кастомную авторизацию //аутентификацию
        //        PaymentDao paymentDao = DaoFactory.getPaymentDao();
       /* Payment payment = new PaymentImpl();
        payment.setAccount(new AccountProxy(1l));
        payment.setAddress("312312");*/


        User user = new UserImpl();
        user.setEmail("emshood@ukr.net");
        user.setBirthday(new Timestamp(102130213l));
        user.setMobilePhone("+3213123");
        user.setFirstName("Oleg");
        user.setLastName("AAa");
        user.setSecondName("Lolchenko");
        System.out.println(user.toString());


        UserService userService = ServiceFactory.getUserService();
        userService.registration(user);
    }
}
