package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import java.util.ArrayList

class SellerPayLoad {
    var userName: String? = null
    var orderId: Int? = null
    var amount: Double? = null
    var itemList: ArrayList<String>? = null
    var orderType: String? = null
    var orderStatus: Enums.OrderStatus? = null
    override fun toString(): String {
        return "SellerPayLoad{" +
                "userName='" + userName + '\'' +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", itemList=" + itemList +
                ", orderType='" + orderType + '\'' +
                ", orderStatus=" + orderStatus +
                '}'
    }
}