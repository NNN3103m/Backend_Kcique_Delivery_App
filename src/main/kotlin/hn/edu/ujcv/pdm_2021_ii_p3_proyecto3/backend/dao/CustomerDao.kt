package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.UserShopListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.CustomerNotificationModel

interface CustomerDao {
    fun loginRegisterCustomer(customer: CustomerModel?): Response<CustomerPlaceModel?>?
    fun verifySeller(customer: CustomerModel?): Response<UserShopListModel?>?

    /** */
    fun updateCustomer(customer: CustomerModel?): Response<String?>?
    fun updateCustomerNotificationToken(customerNotificationModel: CustomerNotificationModel?): Response<String?>?
    fun updateCustomerPlaceData(CustomerPlaceModel: CustomerPlaceModel?): Response<String?>?
}