package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class StatusModel {
    var statusOrderId: Int? = null
    var status: String? = null

    override fun toString(): String {
        return "StatusModel{" +
                "statusOrderId=" + statusOrderId +
                ",status='" + status + '\'' +
                '}'
    }
}