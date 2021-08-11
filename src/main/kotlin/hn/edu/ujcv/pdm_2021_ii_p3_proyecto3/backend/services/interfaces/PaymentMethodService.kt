package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.PaymentMethodModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response


interface PaymentMethodService {
    fun insertPaymentMethod(payments: PaymentMethodModel?): Response<String?>?
    fun getPaymentMethodById(paymentId: PaymentMethodModel?): Response<String?>?
    fun updatePaymentMethod(paymentId: PaymentMethodModel?): Response<String?>?
    fun deletePaymentMethod(paymentId: PaymentMethodModel?): Response<String?>?

}