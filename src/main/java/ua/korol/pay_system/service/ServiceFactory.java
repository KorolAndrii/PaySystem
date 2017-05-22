package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.dao.DaoFactory;
import ua.korol.pay_system.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static Map<String, Service> serviceMap = new HashMap<>();

    private ServiceFactory() {
    }

    public static AccountService getAccountService() {
        AccountService accountService = (AccountServiceImpl)serviceMap.get(AccountService.class.getSimpleName());
        if (accountService == null) {
            accountService = new AccountServiceImpl(DaoFactory.getAccountDao());
            serviceMap.put(AccountService.class.getSimpleName(), accountService);
        }
        return accountService;
    }

    public static CardService getCardService() {
        CardService cardService = (CardServiceImpl)serviceMap.get(CardService.class.getSimpleName());
        if (cardService == null) {
            cardService = new CardServiceImpl(DaoFactory.getCardDao());
            serviceMap.put(CardService.class.getSimpleName(), cardService);
        }
        return cardService;
    }

    public static PaymentService getPaymentService() {
        PaymentService paymentService = (PaymentServiceImpl)serviceMap.get(PaymentService.class.getSimpleName());
        if (paymentService == null) {
            paymentService = new PaymentServiceImpl(DaoFactory.getPaymentDao());
            serviceMap.put(PaymentService.class.getSimpleName(), paymentService);
        }
        return paymentService;
    }

    public static PaymentTemplateService getPaymentTemplateService() {
        PaymentTemplateService paymentTemplateService = (PaymentTemplateServiceImpl)serviceMap.get(PaymentTemplateService.class.getSimpleName());
        if (paymentTemplateService == null) {
            paymentTemplateService = new PaymentTemplateServiceImpl(DaoFactory.getPaymentTemplateDao());
            serviceMap.put(PaymentTemplateService.class.getSimpleName(), paymentTemplateService);
        }
        return paymentTemplateService;
    }

    public static UserService getUserService() {
        UserService userService = (UserServiceImpl)serviceMap.get(UserService.class.getSimpleName());
        if (userService == null) {
            userService = new UserServiceImpl(DaoFactory.getUserDao());
            serviceMap.put(UserService.class.getSimpleName(), userService);
        }
        return userService;
    }
}
