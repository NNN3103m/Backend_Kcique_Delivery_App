package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.AddressModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response

interface AddressService {
    fun insertAddress(address: AddressModel?): Response<String?>?
    fun getAddressById(adressId: AddressModel?): Response<String?>?
    fun updateAddress(adressId: AddressModel?): Response<String?>?
    fun deleteAddress(adressId: AddressModel?): Response<String?>?
}