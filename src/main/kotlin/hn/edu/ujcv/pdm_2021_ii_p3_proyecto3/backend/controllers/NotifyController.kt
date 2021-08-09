package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.NotifyApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.NotifyApi.notifyUrl
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.NotificationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.NotifyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_URL)
class NotifyController {
    @Autowired
    var notifyService: NotifyService? = null
    @PostMapping(value = [notifyUrl])
    fun notifyNewUrl(@RequestBody notificationModel: NotificationModel?): Response<String?>? {
        return notifyService!!.sendGlobalNotification(notificationModel)
    }

    @PostMapping(value = [notifyNewArrival])
    fun notifyNewArrival(@RequestBody notificationModel: NotificationModel?): Response<String?>? {
        return notifyService!!.sendGlobalNotification(notificationModel)
    }
}