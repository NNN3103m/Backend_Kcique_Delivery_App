package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderItemListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.NotificationModel

interface NotifyDao {
    fun sendGlobalNotification(notificationModel: NotificationModel?): Response<String?>?
    fun notifyOrderStatusToSeller(response: Response<OrderItemListModel?>?)
    fun notifyOrderStatus(response: Response<OrderItemListModel?>?)
}