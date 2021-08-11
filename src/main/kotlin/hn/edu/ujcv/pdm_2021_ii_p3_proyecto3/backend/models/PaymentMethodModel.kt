package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models


class PaymentMethodModel {
    var paymentId: Int? = null
    var paymentDescription: String? = null
    override fun toString(): String {
        return "PaymentMethodModel{" +
                "paymentId=" + paymentId +
                ", paymentDescription='" + paymentDescription + '\'' +
                '}'
    }
}