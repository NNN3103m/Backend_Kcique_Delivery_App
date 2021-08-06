package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class TransactionModel {
    var transactionId: String? = null
    var bankTransactionId: String? = null
    private var transactionAmount: Double? = null
    var currency: String? = null
    var responseCode: String? = null
    var responseMessage: String? = null
    var gatewayName: String? = null
    var bankName: String? = null
    var paymentMode: String? = null
    var checksumHash: String? = null
    var orderModel: OrderModel
    fun transactionAmountGet(): Double? {
        return transactionAmount
    }

    fun transactionAmountSet(transactionAmount: Double?) {
        this.transactionAmount = transactionAmount
    }

    override fun toString(): String {
        return "TransactionModel{" +
                "transactionId='" + transactionId + '\'' +
                ", bankTransactionId='" + bankTransactionId + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", currency='" + currency + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", checksumHash='" + checksumHash + '\'' +
                ", orderModel=" + orderModel +
                '}'
    }

    init {
        orderModel = OrderModel()
    }
}