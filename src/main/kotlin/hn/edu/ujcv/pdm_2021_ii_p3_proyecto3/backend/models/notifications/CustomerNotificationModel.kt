package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications

class CustomerNotificationModel {
    var id: Int? = null
    var notificationToken: String? = null
    override fun toString(): String {
        return "CustomerNotificationModel{" +
                "id=" + id +
                ", notificationToken='" + notificationToken + '\'' +
                '}'
    }
}