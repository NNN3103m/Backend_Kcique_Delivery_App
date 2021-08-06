package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class OrderItemListModel {
    var transactionModel: TransactionModel? = null
    var orderItemsList: List<OrderItemModel>? = null
    var orderStatusModel: List<OrderStatusModel>? = null
    override fun toString(): String {
        return "OrderItemListModel{" +
                "transactionModel=" + transactionModel +
                ", orderItemsList=" + orderItemsList +
                ", orderStatusModel=" + orderStatusModel +
                '}'
    }
}