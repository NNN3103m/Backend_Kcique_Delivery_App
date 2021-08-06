package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopConfigurationModel

interface ShopService {
    fun insertShop(configurationModel: ConfigurationModel?): Response<String?>?
    fun getShopById(placeId: Int?): Response<ShopConfigurationModel?>?
    fun getShopByPlaceId(placeId: Int?): Response<List<ShopConfigurationModel?>?>?
    fun updateShopConfiguration(configurationModel: ConfigurationModel?): Response<String?>?
    fun deleteShopById(shopId: Int?): Response<String?>?
}