package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import java.sql.Timestamp

class OrderModel {
    var id: Int? = null
    var userModel: UserModel
    var shopModel: ShopModel

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Kolkata")
    var date: Timestamp? = null
    var orderStatus: Enums.OrderStatus? = null
    var price: Double? = null
    var deliveryPrice: Double? = null
    var deliveryLocation: String? = null
    var cookingInfo: String? = null
    var rating: Double? = null
    var feedback: String? = null
    var secretKey: String? = null
    override fun toString(): String {
        return "OrderModel{" +
                "id=" + id +
                ", userModel=" + userModel +
                ", shopModel=" + shopModel +
                ", date=" + date +
                ", orderStatus=" + orderStatus +
                ", price=" + price +
                ", deliveryPrice=" + deliveryPrice +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", cookingInfo='" + cookingInfo + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}'
    }

    init {
        userModel = UserModel()
        shopModel = ShopModel()
    }
}