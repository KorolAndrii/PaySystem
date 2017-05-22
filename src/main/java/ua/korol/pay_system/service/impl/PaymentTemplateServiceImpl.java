package ua.korol.pay_system.service.impl;

import ua.korol.pay_system.persistence.dao.PaymentTemplateDao;
import ua.korol.pay_system.persistence.model.PaymentTemplate;
import ua.korol.pay_system.service.PaymentTemplateService;

public class PaymentTemplateServiceImpl implements PaymentTemplateService {
    private PaymentTemplateDao paymentTemplateDao;

    public PaymentTemplateServiceImpl(PaymentTemplateDao paymentTemplateDao) {
        this.paymentTemplateDao = paymentTemplateDao;
    }

    @Override
    public PaymentTemplate getPaymentTemplateById(Long id) {
        return paymentTemplateDao.getById(id);
    }

    @Override
    public PaymentTemplate getTemplateByName(String name) {
        return paymentTemplateDao.getByTemplateName(name);
    }

    @Override
    public long insertPaymentTemplate(PaymentTemplate paymentTemplate) {
        return paymentTemplateDao.insertPaymentTemplate(paymentTemplate);
    }

    @Override
    public long deletePaymentTemplate(PaymentTemplate paymentTemplate) {
        return paymentTemplateDao.deletePaymentTemplate(paymentTemplate);
    }

    @Override
    public long updatePaymentTemplate(PaymentTemplate paymentTemplate) {
        return paymentTemplateDao.deletePaymentTemplate(paymentTemplate);
    }
}
