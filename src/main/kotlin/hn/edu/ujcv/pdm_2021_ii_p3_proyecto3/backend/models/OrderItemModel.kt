package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class OrderItemModel {

    @Column(name = "orderItemQuantity", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank(message = "Agregue una cantidad")
    var quantity: Int? = null

    @Column(name = "orderItemPrice", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank(message = "Agregue el precio")
    var price: Double? = null

    var orderModel: OrderModel
    var itemModel: ItemModel
    override fun toString(): String {
        return "OrderItemModel{" +
                "orderModel=" + orderModel +
                ", itemModel=" + itemModel +
                ", quantity=" + quantity +
                ", price=" + price +
                '}'
    }

    init {
        orderModel = OrderModel()
        itemModel = ItemModel()
    }
}
