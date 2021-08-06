package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import java.sql.Timestamp

class OrderStatusModel {
    var orderId: Int? = null
    var orderStatus: Enums.OrderStatus? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Kolkata")
    var updatedTime: Timestamp? = null
    override fun toString(): String {
        return "OrderStatusModel{" +
                "orderId=" + orderId +
                ", status=" + orderStatus +
                ", updatedTime=" + updatedTime +
                '}'
    }
}
