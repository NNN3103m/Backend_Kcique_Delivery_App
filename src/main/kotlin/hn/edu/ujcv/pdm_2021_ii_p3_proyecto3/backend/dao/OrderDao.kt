package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.exceptions.GenericException
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderItemListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionTokenModel

interface OrderDao {
    @Throws(GenericException::class)
    fun insertOrder(orderItemListModel: OrderItemListModel?): Response<TransactionTokenModel?>?
    fun placeOrder(orderId: Int?): Response<String?>?

    /** */
    fun getOrderByUserId(userId: Int?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderBySearchQuery(shopId: Int?, searchItem: String?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderByShopIdPagination(shopId: Int?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderByShopId(shopId: Int?): Response<List<OrderItemListModel?>?>?
    fun getOrderById(orderId: Int?): Response<OrderItemListModel?>?

    /** */
    fun updateOrderRating(orderModel: OrderModel?): Response<String?>?
    fun updateOrderStatus(orderModel: OrderModel?): Response<String?>?

    /** */
    fun updatePendingOrder()
    fun updatedRefundOrder()
}