package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.implementations

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.ShopDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.exceptions.GenericException
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopConfigurationModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopServiceImpl : ShopService {
    @Autowired
    var shopDao: ShopDao? = null
    override fun insertShop(configurationModel: ConfigurationModel?): Response<String> {
        TODO("Not yet implemented")
    }
//    override fun insertShop(configurationModel: ConfigurationModel?): Response<String> {
//        var response: Response<String> = Response()
//        try {
//            response = shopDao?.insertShop(configurationModel) ?:
//        } catch (e: GenericException) {
//            response = e.getResponse() as Response<String>
//        } catch (e: Exception) {
//            System.err.println(e.javaClass.name + ": " + e.message)
//        }
//        return response
//    }

    override fun getShopById(shopId: Int?): Response<ShopConfigurationModel?>? {
        return shopDao?.getShopById(shopId)
    }

    override fun getShopByPlaceId(placeId: Int?): Response<List<ShopConfigurationModel?>?>? {
        return shopDao?.getShopsByPlaceId(placeId)
    }

    override fun updateShopConfiguration(configurationModel: ConfigurationModel?): Response<String?>? {
        return shopDao?.updateShopConfigurationModel(configurationModel)
    }

    override fun deleteShopById(shopId: Int?): Response<String?>? {
        return shopDao?.deleteShopById(shopId)
    }
}
