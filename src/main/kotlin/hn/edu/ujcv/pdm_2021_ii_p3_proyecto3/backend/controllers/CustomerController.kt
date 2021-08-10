package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.CustomerPlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.notifications.CustomerNotificationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

class CustomerController {
    @Autowired
    var customerService: CustomerService? = null
    @PostMapping("/post/{customerId}")
    fun loginRegisterCustomer(@RequestBody customer: CustomerModel?): Response<CustomerPlaceModel?>? {
        return customerService!!.loginRegisterCustomer(customer)
    }


    /** */
    @PutMapping("/put/")
    fun updateCustomer(@RequestBody customerModel: CustomerModel?): Response<String?>? {
        return customerService!!.updateCustomer(customerModel)
    }

    @PutMapping("/put/")
    fun updateCustomerNotificationToken(@RequestBody customerNotificationModel: CustomerNotificationModel?): Response<String?>? {
        return customerService!!.updateCustomerNotificationToken(customerNotificationModel)
    }

    @PutMapping("/put/")
    fun updateCustomerPlaceData(@RequestBody customerPlaceModel: CustomerPlaceModel?): Response<String?>? {
        return customerService!!.updateCustomerPlaceData(customerPlaceModel)
    }
}