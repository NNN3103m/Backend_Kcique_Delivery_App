package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class TransactionTokenModel {

    @Column(name = "transactionTokenOrderId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    @field:Id
    var orderId = 0

    @Column(name = "transactionToken", insertable = true, nullable = false )
    @field:Min(10)
    @field:Max(65)
    @field:NotBlank(message = "")
    var transactionToken: String? = null
}