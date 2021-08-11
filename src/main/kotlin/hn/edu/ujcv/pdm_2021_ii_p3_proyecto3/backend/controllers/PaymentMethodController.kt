package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers


import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.PaymentMethodModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.PaymentMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class PaymentMethodController {
    @Autowired
    var paymentMethodService: PaymentMethodService? = null

    @PostMapping("/post/{paymentId}")
    fun insertPaymentMethod(@Valid @RequestBody paymentModel: PaymentMethodModel?): Response<String?>? {
        return paymentMethodService!!.insertPaymentMethod(paymentModel)
    }
    @GetMapping("/get/{paymentId}")
    fun getPaymentMethod(@RequestBody paymentModel: PaymentMethodModel?): Response<String?>? {
        return paymentMethodService!!.getPaymentMethodById(paymentModel)
    }

    @PutMapping("/get/{paymentId}")
    fun updatePaymentMethod(@RequestBody paymentModel: PaymentMethodModel?): Response<String?>? {
        return paymentMethodService!!.updatePaymentMethod(paymentModel)
    }

    @DeleteMapping("/delete/{paymentId}")
    fun deleteAddress(@RequestBody paymentModel: PaymentMethodModel?): Response<String?>? {
        return paymentMethodService!!.deletePaymentMethod(paymentModel)
    }

}