package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class OrderStatusModel {
    @Column(name = "orderId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    var orderId: Int? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Chicago")
    @Column(name = "orderUpdatedTime", insertable = true, nullable = false )
    @field:Min(5)
    @field:Max(5)
    @field:NotBlank
    var updatedTime: Timestamp? = null

    var orderStatus: Enums.OrderStatus? = null
    override fun toString(): String {
        return "OrderStatusModel{" +
                "orderId=" + orderId +
                ", status=" + orderStatus +
                ", updatedTime=" + updatedTime +
                '}'
    }
}
