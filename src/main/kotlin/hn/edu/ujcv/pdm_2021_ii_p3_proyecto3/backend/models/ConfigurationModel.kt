package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class ConfigurationModel {
    var shopModel: ShopModel
    var merchantId: String? = null
    var deliveryPrice: Double? = null
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