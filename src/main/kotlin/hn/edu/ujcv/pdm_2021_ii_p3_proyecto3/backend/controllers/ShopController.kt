package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.ShopApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

//@RestController
//@RequestMapping(value = [BASE_URL])
class ShopController {

    @Autowired
    var shopService: ShopService? = null

    @PostMapping("/post")
    fun insertShop(@Valid @RequestBody configurationModel: ConfigurationModel?): Response<String> {
        return this.shopService!!.insertShop(configurationModel)
    }

    @GetMapping("/get/{shopId}")
    fun getShopById(@PathVariable("shopId") shopId: Int?): Response<ShopConfigurationModel?>? {
        return shopService!!.getShopById(shopId)
    }

    @GetMapping("/getByPlaceId")
    fun getShopsByPlaceId(@PathVariable("placeId") placeId: Int?): Response<List<ShopConfigurationModel?>?>? {
        return shopService!!.getShopByPlaceId(placeId)
    }

    @PutMapping("/put/{id}")
    fun updateShopConfiguration(@RequestBody configurationModel: ConfigurationModel?): Response<String?>? {
        return shopService!!.updateShopConfiguration(configurationModel)
    }

    @DeleteMapping("/delete/{shopId}")
    fun deleteShop(@PathVariable("shopId") shopId: Int?): Response<String?>? {
        return shopService!!.deleteShopById(shopId)
    }
}