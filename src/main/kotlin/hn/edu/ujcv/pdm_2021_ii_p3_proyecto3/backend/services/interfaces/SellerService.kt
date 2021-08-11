package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.PaymentMethodModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.SellerModel

interface SellerService {
    fun insertSeller(sellers: SellerModel?): Response<String?>?
    fun getSellerId(sellersId: SellerModel?): Response<String?>?
    fun updateSeller(sellersId: SellerModel?): Response<String?>?
    fun deleteSeller(sellersId: SellerModel?): Response<String?>?

}