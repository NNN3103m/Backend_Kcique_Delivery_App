package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums

class NotificationModel {
    var type: Enums.NotificationType? = null
    var title: String? = null
    var message: String? = null
    var payload: String? = null
    override fun toString(): String {
        return "NotificationModel{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", payload='" + payload + '\'' +
                '}'
    }
}