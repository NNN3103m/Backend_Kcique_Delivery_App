package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.implementations

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.NotifyDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.UserDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.NotificationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.NotifyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotifyServiceImpl : NotifyService {
    @Autowired
    var notifyDao: NotifyDao? = null

    @Autowired
    var userDao: UserDao? = null
    override fun sendGlobalNotification(notificationModel: NotificationModel?): Response<String?>? {
        return notifyDao?.sendGlobalNotification(notificationModel)
    }
}
