package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.model.PaymentTemplate;

public interface PaymentTemplateService extends Service {
    PaymentTemplate getPaymentTemplateById(Long id);

    PaymentTemplate getTemplateByName(String name);

    long insertPaymentTemplate(PaymentTemplate paymentTemplate);

    long deletePaymentTemplate(PaymentTemplate paymentTemplate);

    long updatePaymentTemplate(PaymentTemplate paymentTemplate);
}
