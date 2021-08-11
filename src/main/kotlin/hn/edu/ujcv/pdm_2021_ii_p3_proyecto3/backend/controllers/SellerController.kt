package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers


import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.SellerModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.SellerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class SellerController {
    @Autowired
    var sellerService: SellerService? = null

    @PostMapping("/post/{sellerId}")
    fun insertSeller(@Valid @RequestBody sellerModel: SellerModel?): Response<String?>? {
        return sellerService!!.insertSeller(sellerModel)
    }
    @GetMapping("/get/{sellerId}")
    fun getSeller(@RequestBody sellerModel: SellerModel?): Response<String?>? {
        return sellerService!!.getSellerId(sellerModel)
    }

    @PutMapping("/put/{sellerId}")
    fun updateSeller(@RequestBody sellerModel: SellerModel?): Response<String?>? {
        return sellerService!!.updateSeller(sellerModel)
    }

    @DeleteMapping("/delete/{sellerId}")
    fun deleteSeller(@RequestBody sellerModel: SellerModel?): Response<String?>? {
        return sellerService!!.deleteSeller(sellerModel)
    }
}