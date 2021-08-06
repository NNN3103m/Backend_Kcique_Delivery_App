package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.ShopApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopConfigurationModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [BASE_URL])
class ShopController {
    @Autowired
    var shopService: ShopService? = null
    @PostMapping(value = [insertShop])
    fun insertShop(@RequestBody configurationModel: ConfigurationModel?): Response<String> {
        return shopService!!.insertShop(configurationModel)
    }

    @GetMapping(value = [getShopById])
    fun getShopById(@PathVariable("shopId") shopId: Int?): Response<ShopConfigurationModel> {
        return shopService!!.getShopById(shopId)
    }

    @GetMapping(value = [getShopsByPlaceId])
    fun getShopsByPlaceId(@PathVariable("placeId") placeId: Int?): Response<List<ShopConfigurationModel>> {
        return shopService!!.getShopByPlaceId(placeId)
    }

    @PatchMapping(value = [updateShopConfiguration])
    fun updateShopConfiguration(@RequestBody configurationModel: ConfigurationModel?): Response<String> {
        return shopService!!.updateShopConfiguration(configurationModel)
    }

    @DeleteMapping(value = [deleteShop])
    fun deleteShop(@PathVariable("shopId") shopId: Int?): Response<String> {
        return shopService!!.deleteShopById(shopId)
    }
}