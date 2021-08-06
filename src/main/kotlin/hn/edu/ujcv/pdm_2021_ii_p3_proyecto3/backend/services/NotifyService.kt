package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.NotificationModel

interface NotifyService {
    fun sendGlobalNotification(notificationModel: NotificationModel?): Response<String?>?
}