package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.implementations

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ErrorLog
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.UserDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserShopListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.UserNotificationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    var userDao: UserDao? = null
    override fun loginRegisterCustomer(user: UserModel?): Response<UserPlaceModel?>? {
        return userDao?.loginRegisterCustomer(user)
    }

    override fun verifySeller(user: UserModel?): Response<UserShopListModel?>? {
        return userDao?.verifySeller(user)
    }

    override fun updateUser(userModel: UserModel?): Response<String?>? {
        var response: Response<String> = Response()
        try {
            response = userDao?.updateUser(userModel) ?:
        } catch (e: Exception) {
            response.setCode(ErrorLog.UDNU1157)
            response.setMessage(ErrorLog.UserDetailNotUpdated)
        }
        return response
    }

    override fun updateUserNotificationToken(userNotificationModel: UserNotificationModel?): Response<String?>? {
        return userDao?.updateUserNotificationToken(userNotificationModel)
    }

    override fun updateUserPlaceData(userPlaceModel: UserPlaceModel?): Response<String?>? {
        var response: Response<String> = Response()
        try {
            response = userDao?.updateUserPlaceData(userPlaceModel) ?:
        } catch (e: Exception) {
            response.setCode(ErrorLog.UDNU1157)
            response.setMessage(ErrorLog.UserDetailNotUpdated)
        }
        return response
    }
}
