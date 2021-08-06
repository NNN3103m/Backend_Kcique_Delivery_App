package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopConfigurationModel

interface ShopDao {
    fun insertShop(configurationModel: ConfigurationModel?): Response<String?>?
    fun getShopsByPlaceId(placeId: Int?): Response<List<ShopConfigurationModel?>?>?
    fun getShopById(shopId: Int?): Response<ShopConfigurationModel?>?
    fun updateShopConfigurationModel(configurationModel: ConfigurationModel?): Response<String?>?
    fun deleteShopById(shopId: Int?): Response<String?>?
}