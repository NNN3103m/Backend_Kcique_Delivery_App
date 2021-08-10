package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserShopListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.CustomerNotificationModel

interface CustomerService {
    fun loginRegisterCustomer(customer: CustomerModel?): Response<CustomerPlaceModel?>?
    fun verifySeller(customer: CustomerModel?): Response<UserShopListModel?>?

    /** */
    fun updateCustomer(customerModel: CustomerModel?): Response<String?>?
    fun updateCustomerNotificationToken(customerNotificationModel: CustomerNotificationModel?): Response<String?>?
    fun updateCustomerPlaceData(customerPlaceModel: CustomerPlaceModel?): Response<String?>?
}