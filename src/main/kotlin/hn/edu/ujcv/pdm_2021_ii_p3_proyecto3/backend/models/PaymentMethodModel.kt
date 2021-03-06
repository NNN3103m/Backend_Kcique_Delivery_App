package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank


class PaymentMethodModel {

    @Column(name = "paymentId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id del metodo de pago")
    @field:Id
    var paymentId: Int? = null

    @Column(name = "paymentDescription", insertable = true, nullable = false )
    @field:Min(10)
    @field:Max(65)
    @field:NotBlank(message = "Por favor ingresar la descripcion del metodo de pago")
    var paymentDescription: String? = null



    override fun toString(): String {
        return "PaymentMethodModel{" +
                "paymentId=" + paymentId +
                ", paymentDescription='" + paymentDescription + '\'' +
                '}'
    }
}