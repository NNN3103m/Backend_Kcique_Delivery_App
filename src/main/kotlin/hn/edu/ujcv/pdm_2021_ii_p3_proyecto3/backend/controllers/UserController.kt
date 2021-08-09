package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.UserApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserShopListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.UserNotificationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(BASE_URL)
class UserController {
    @Autowired
    var userService: UserService? = null
    @PostMapping(value = [loginRegisterCustomer])
    fun loginRegisterCustomer(@RequestBody user: UserModel?): Response<UserPlaceModel?>? {
        return userService!!.loginRegisterCustomer(user)
    }

    @PostMapping(value = [verifySeller])
    fun verifySeller(@RequestBody user: UserModel?): Response<UserShopListModel?>? {
        return userService!!.verifySeller(user)
    }

    /** */
    @PutMapping(value = [updateUser])
    fun updateUser(@RequestBody userModel: UserModel?): Response<String?>? {
        return userService!!.updateUser(userModel)
    }

    @PutMapping(value = [updateUserNotificationToken])
    fun updateUserNotificationToken(@RequestBody userNotificationModel: UserNotificationModel?): Response<String?>? {
        return userService!!.updateUserNotificationToken(userNotificationModel)
    }

    @PutMapping(value = [updateUserPlaceData])
    fun updateUserPlaceData(@RequestBody userPlaceModel: UserPlaceModel?): Response<String?>? {
        return userService!!.updateUserPlaceData(userPlaceModel)
    }
}