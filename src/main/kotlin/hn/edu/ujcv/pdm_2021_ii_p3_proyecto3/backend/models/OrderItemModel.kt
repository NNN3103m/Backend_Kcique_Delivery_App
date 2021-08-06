package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class OrderItemModel {
    var orderModel: OrderModel
    var itemModel: ItemModel
    var quantity: Int? = null
    var price: Double? = null
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