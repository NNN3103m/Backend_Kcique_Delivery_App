package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class OrderModel {
    @Column(name = "orderId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Ingresar el Id")
    @field:Id
    var id: Int? = null


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Chicago")
    @Column(name = "orderDate", insertable = true, nullable = false )
    @field:Min(5)
    @field:Max(5)
    @field:NotBlank(message = "Ingresar la fecha")
    var date: Timestamp? = null

    @Column(name = "orderPice", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank(message = "Ingresar el precio")
    var price: Double? = null

    @Column(name = "deliveryPrice", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank
    var deliveryPrice: Double? = null

    @Column(name = "deloveryLocation", insertable = true, nullable = false )
    @field:Min(15)
    @field:Max(65)
    @field:NotBlank
    var deliveryLocation: String? = null

    @Column(name = "secretKey", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    @GeneratedValue
    var secretKey: String? = null

    var cookingInfo: String? = null
    var feedback: String? = null
    var rating: Double? = null
    var orderStatus: Enums.OrderStatus? = null
    var userModel: UserModel
    var shopModel: ShopModel
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

    fun getOrderStatus(): Any {
        return "order status" + orderStatus
    }

    @JvmName("getId1")
    fun getId(): Int {
        return 1
    }

    init {
        userModel = UserModel()
        shopModel = ShopModel()
    }
}