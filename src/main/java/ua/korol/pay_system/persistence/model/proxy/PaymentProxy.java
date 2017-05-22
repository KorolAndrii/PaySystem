package ua.korol.pay_system.persistence.model.proxy;

import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.Payment;
import ua.korol.pay_system.persistence.model.real.PaymentImpl;
import ua.korol.pay_system.service.PaymentService;
import ua.korol.pay_system.service.ServiceFactory;

import java.sql.Timestamp;

public class PaymentProxy implements Payment {
    private Long id;

    private Payment payment;

    private PaymentService paymentService;

    public PaymentProxy() {
    }

    public PaymentProxy(Long id) {
        this.id = id;
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
        checkPaymentForExist();
        return payment.getPayDate();
    }

    @Override
    public void setPayDate(Timestamp payDate) {
        checkPaymentForExist();
        payment.setPayDate(payDate);
    }

    @Override
    public String getAddress() {
        checkPaymentForExist();
        return payment.getAddress();
    }

    @Override
    public void setAddress(String address) {
        checkPaymentForExist();
        payment.setAddress(address);
    }

    @Override
    public Double getAmount() {
        checkPaymentForExist();
        return payment.getAmount();
    }

    @Override
    public void setAmount(Double amount) {
        checkPaymentForExist();
        payment.setAmount(amount);
    }


    @Override
    public Account getAccount() {
        checkPaymentForExist();
        return payment.getAccount();
    }

    @Override
    public void setAccount(Account account) {
        checkPaymentForExist();
        payment.setAccount(account);
    }

    private void checkPaymentForExist() {
        if (payment == null) {
            paymentService = ServiceFactory.getPaymentService();
            payment = downloadPayment();
        }
    }

    private PaymentImpl downloadPayment() {
        return (PaymentImpl) paymentService.getPaymentById(id);
    }
}
