package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.OrderApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderItemListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionTokenModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(BASE_URL)
class OrderController {
    @Autowired
    var orderService: OrderService? = null
    @PostMapping(value = [insertOrder])
    fun insertOrder(@RequestBody orderItemList: OrderItemListModel?): Response<TransactionTokenModel?>? {
        return orderService!!.insertOrder(orderItemList)
    }

    @PostMapping(value = [placeOrder])
    fun placeOrder(@PathVariable("orderId") orderId: Int?): Response<String?>? {
        return orderService!!.placeOrder(orderId)
    }

    @GetMapping(value = [getOrderByUserId])
    fun getOrderByUserId(@PathVariable("userId") userId: Int?, @PathVariable("pageNum") pageNum: Int?, @PathVariable("pageCount") pageCount: Int?): Response<List<OrderItemListModel?>?>? {
        return orderService!!.getOrderByUserId(userId, pageNum, pageCount)
    }

    @GetMapping(value = [getOrderBySearchQuery])
    fun getOrderBySearchQuery(@PathVariable("shopId") shopId: Int?, @PathVariable("searchItem") searchItem: String?, @PathVariable("pageNum") pageNum: Int?, @PathVariable("pageCount") pageCount: Int?): Response<List<OrderItemListModel?>?>? {
        return orderService!!.getOrderBySearchQuery(shopId, searchItem, pageNum, pageCount)
    }

    @GetMapping(value = [getOrderByShopIdPagination])
    fun getOrderByShopIdPagination(@PathVariable("shopId") shopId: Int?, @PathVariable("pageNum") pageNum: Int?, @PathVariable("pageCount") pageCount: Int?): Response<List<OrderItemListModel?>?>? {
        return orderService!!.getOrderByShopIdPagination(shopId, pageNum, pageCount)
    }

    @GetMapping(value = [getOrderByShopId])
    fun getOrderByShopId(@PathVariable("shopId") shopId: Int?): Response<List<OrderItemListModel?>?>? {
        return orderService!!.getOrderByShopId(shopId)
    }

    @GetMapping(value = [getOrderById])
    fun getOrderById(@PathVariable("id") id: Int?): Response<OrderItemListModel?>? {
        return orderService!!.getOrderById(id)
    }

    @PatchMapping(value = [updateOrderRating])
    fun updateOrderRating(@RequestBody orderModel: OrderModel?): Response<String?>? {
        return orderService!!.updateOrderRating(orderModel)
    }

    @PatchMapping(value = [updateOrderStatus])
    fun updateOrderStatus(@RequestBody orderModel: OrderModel?): Response<String?>? {
        return orderService!!.updateOrderStatus(orderModel)
    }
}