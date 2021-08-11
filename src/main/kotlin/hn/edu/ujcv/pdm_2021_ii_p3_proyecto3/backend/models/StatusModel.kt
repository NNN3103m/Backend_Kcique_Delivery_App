package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class StatusModel {

    @Column(name = "statusOrderId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id del estado del pedido")
    @field:Id
    var statusOrderId: Int? = null

    @Column(name = "status", insertable = true, nullable = false )
    @field:Min(15)
    @field:Max(65)
    @field:NotBlank(message = "Por favor ingresar el estado del pedido")
    var status: String? = null

    override fun toString(): String {
        return "StatusModel{" +
                "statusOrderId=" + statusOrderId +
                ",status='" + status + '\'' +
                '}'
    }
}