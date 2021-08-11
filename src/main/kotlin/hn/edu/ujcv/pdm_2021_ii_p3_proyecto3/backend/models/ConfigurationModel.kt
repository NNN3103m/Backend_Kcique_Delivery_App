package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class ConfigurationModel {

    @Column(name = "merchantId", unique = true, insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id")
    var merchantId: String? = null

    @Column(name = "deliveryPrice", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank(message = "Por favor ingresar el precio de la entrega")
    var deliveryPrice: Double? = null

    var shopModel: ShopModel
    var isDeliveryAvailable: Int? = null
    var isOrderTaken: Int? = null
    override fun toString(): String {
        return "ConfigurationModel{" +
                "shopModel=" + shopModel +
                ", merchantId='" + merchantId + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", isDeliveryAvailable=" + isDeliveryAvailable +
                ", isOrderTaken=" + isOrderTaken +
                '}'
    }

    init {
        shopModel = ShopModel()
    }
}