package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderItemListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionTokenModel

interface OrderService {
    fun insertOrder(orderItemListModel: OrderItemListModel?): Response<TransactionTokenModel?>?
    fun placeOrder(orderId: Int?): Response<String?>?
    fun getOrderByUserId(userId: Int?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderBySearchQuery(
        shopId: Int?,
        searchItem: String?,
        pageNum: Int?,
        pageCount: Int?
    ): Response<List<OrderItemListModel?>?>?

    fun getOrderByShopIdPagination(shopId: Int?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderByShopId(shopId: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderById(id: Int?): Response<OrderItemListModel?>?
    fun updateOrderRating(orderModel: OrderModel?): Response<String?>?
    fun updateOrderStatus(orderModel: OrderModel?): Response<String?>?
}