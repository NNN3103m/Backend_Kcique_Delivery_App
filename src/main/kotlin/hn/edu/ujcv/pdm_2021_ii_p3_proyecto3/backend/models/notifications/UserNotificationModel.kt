package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications

class UserNotificationModel {
    var id: Int? = null
    var notificationToken: String? = null
    override fun toString(): String {
        return "UserNotificationModel{" +
                "id=" + id +
                ", notificationToken='" + notificationToken + '\'' +
                '}'
    }
}