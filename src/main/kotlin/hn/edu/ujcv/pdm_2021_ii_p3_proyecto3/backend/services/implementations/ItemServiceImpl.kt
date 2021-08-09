package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.implementations

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ErrorLog.IDNU1207
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ErrorLog.ItemDetailNotUpdated
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.ItemDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ItemModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl : ItemService {
    @Autowired
    var itemDao: ItemDao? = null
    override fun insertItem(itemModelList: List<ItemModel?>?): Response<String?>? {
        var response: Response<String?>? = Response()
        if (itemModelList != null && !itemModelList.isEmpty()) response = itemDao!!.insertItem(itemModelList)
        return response
    }

    override fun getItemsByShopId(shopId: Int?): Response<List<ItemModel?>?>? {
        return itemDao!!.getItemsByShopId(shopId)
    }

    override fun getItemsByName(
        placeId: Int?,
        itemName: String?
    ): Response<List<ItemModel?>?>? {
        return itemDao!!.getItemsByName(placeId, itemName)
    }

    override fun updateItem(itemModelList: List<ItemModel?>?): Response<String?>? {
        var response: Response<String?>? = Response()
        try {
            response = itemDao!!.updateItem(itemModelList)
        } catch (e: Exception) {
            if (response != null) {
                response.setCode(IDNU1207)
            }
            if (response != null) {
                response.setMessage(ItemDetailNotUpdated)
            }
        }
        return response
    }

    override fun deleteItemById(itemId: Int?): Response<String?>? {
        return itemDao!!.deleteItemById(itemId)
    }
}

