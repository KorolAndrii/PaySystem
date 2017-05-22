package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.model.PaymentTemplate;

public interface PaymentTemplateDao extends Dao {
    PaymentTemplate getById(Long id);

    PaymentTemplate getByTemplateName(String name);

    long insertPaymentTemplate(PaymentTemplate paymentTemplate);

    long deletePaymentTemplate(PaymentTemplate paymentTemplate);

    long updatePaymentTemplate(PaymentTemplate paymentTemplate);
}
