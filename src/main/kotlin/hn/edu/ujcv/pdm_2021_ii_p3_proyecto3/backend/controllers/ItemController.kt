package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.ItemApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ItemModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [BASE_URL])
class ItemController {
    @Autowired
    var itemService: ItemService? = null
    @PostMapping("/post/{itemId}")
    fun insertItem(@RequestBody itemModelList: List<ItemModel?>?): Response<String?>? {
        return itemService!!.insertItem(itemModelList)
    }

    @GetMapping("/get/{shopId}")
    fun getItemsByShopId(@PathVariable("shopId") shopId: Int?): Response<List<ItemModel?>?>? {
        return itemService!!.getItemsByShopId(shopId)
    }

    @GetMapping("/get/{placeId}")
    fun getItemsByName(@PathVariable("placeId") placeId: Int?, @PathVariable("itemName") itemName: String?): Response<List<ItemModel?>?>? {
        return itemService!!.getItemsByName(placeId, itemName)
    }

    @PatchMapping("/put/{shopId}")
    fun updateItem(@RequestBody itemModelList: List<ItemModel?>?): Response<String?>? {
        return itemService!!.updateItem(itemModelList)
    }

    @DeleteMapping("/delete/{shopId}")
    fun deleteItemById(@PathVariable("itemId") itemId: Int?): Response<String?>? {
        return itemService!!.deleteItemById(itemId)
    }
}