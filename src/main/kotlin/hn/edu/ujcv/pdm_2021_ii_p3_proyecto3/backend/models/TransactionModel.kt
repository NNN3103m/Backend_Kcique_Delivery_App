package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class TransactionModel {

    @Column(name = "transactionID", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "")
    var transactionId: String? = null

    @Column(name = "banckTransactionID", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    var bankTransactionId: String? = null

    @Column(name = "bankName", unique = true, insertable = true, nullable = false )
    @field:Min(5)
    @field:Max(65)
    @field:NotBlank
    var bankName: String? = null


    private var transactionAmount: Double? = null
    var currency: String? = null
    var responseCode: String? = null
    var responseMessage: String? = null
    var gatewayName: String? = null
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