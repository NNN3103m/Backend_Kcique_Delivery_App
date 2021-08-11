package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.AddressModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class AddressController {
    @Autowired
    var addressService: AddressService? = null
    @PostMapping("/post")
    fun insertAddress(@Valid @RequestBody address: AddressModel?): Response<String?>?{
        return addressService!!.insertAddress(address)
    }

    @GetMapping("/get")
    fun getAddress(@RequestBody address: AddressModel?): Response<String?>? {
        return addressService!!.getAddressById(address)
    }

    @PutMapping("/put")
    fun updateAddress(@RequestBody address: AddressModel?): Response<String?>? {
        return addressService!!.updateAddress(address)
    }
    @DeleteMapping("/delete")
    fun deleteAddress(@RequestBody address: AddressModel?): Response<String?>? {
        return addressService!!.deleteAddress(address)
    }



}