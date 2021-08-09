package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ItemModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response

interface ItemService {
    fun insertItem(itemModelList: List<ItemModel?>?): Response<String?>?
    fun getItemsByShopId(shopId: Int?): Response<List<ItemModel?>?>?
    fun getItemsByName(placeId: Int?, itemName: String?): Response<List<ItemModel?>?>?
    fun updateItem(itemModelList: List<ItemModel?>?): Response<String?>?
    fun deleteItemById(itemId: Int?): Response<String?>?
}