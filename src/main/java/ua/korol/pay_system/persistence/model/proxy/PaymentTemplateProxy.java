package ua.korol.pay_system.persistence.model.proxy;

import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.PaymentTemplate;
import ua.korol.pay_system.persistence.model.real.PaymentTemplateImpl;
import ua.korol.pay_system.service.PaymentTemplateService;
import ua.korol.pay_system.service.ServiceFactory;

import java.sql.Timestamp;

public class PaymentTemplateProxy implements PaymentTemplate{
    private Long id;

    private PaymentTemplate paymentTemplate;

    private PaymentTemplateService paymentTemplateService;

    public PaymentTemplateProxy() {
    }

    public PaymentTemplateProxy(Long id) {
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
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getRequisites() {
        return null;
    }

    @Override
    public void setRequisites(String requisites) {

    }

    @Override
    public Boolean getState() {
        return null;
    }

    @Override
    public void setState(Boolean state) {

    }

    @Override
    public Timestamp getRegularPaymentDate() {
        return null;
    }

    @Override
    public void setRegularPaymentDate(Timestamp regularPaymentDate) {

    }

    @Override
    public Account getAccount() {
        return null;
    }

    @Override
    public void setAccount(Account account) {

    }

    private void checkPaymentTemplateForExist() {
        if (paymentTemplate == null) {
            paymentTemplateService = ServiceFactory.getPaymentTemplateService();
            paymentTemplate = downloadPaymentTemplate();
        }
    }

    private PaymentTemplateImpl downloadPaymentTemplate() {
        return (PaymentTemplateImpl) paymentTemplateService.getPaymentTemplateById(id);
    }
}
