package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserShopListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.UserNotificationModel

interface UserService {
    fun loginRegisterCustomer(user: UserModel?): Response<UserPlaceModel?>?
    fun verifySeller(user: UserModel?): Response<UserShopListModel?>?

    /** */
    fun updateUser(userModel: UserModel?): Response<String?>?
    fun updateUserNotificationToken(userNotificationModel: UserNotificationModel?): Response<String?>?
    fun updateUserPlaceData(userPlaceModel: UserPlaceModel?): Response<String?>?
}