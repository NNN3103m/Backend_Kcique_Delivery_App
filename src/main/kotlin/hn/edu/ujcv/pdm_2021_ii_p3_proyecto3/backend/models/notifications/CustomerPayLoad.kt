package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums

class CustomerPayLoad {
    var orderId: Int? = null
    var orderStatus: Enums.OrderStatus? = null
    var shopName: String? = null
    var secretKey: String? = null
    override fun toString(): String {
        return "OrderStatusPayLoad{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", shopName='" + shopName + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}'
    }
}