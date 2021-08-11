package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.implementations

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ErrorLog
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.NotifyDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao.OrderDao
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.exceptions.GenericException
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderItemListModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.OrderModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionTokenModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {
    @Autowired
    var orderDao: OrderDao? = null

    @Autowired
    var notifyDao: NotifyDao? = null
    override fun insertOrder(orderItemListModel: OrderItemListModel?): Response<TransactionTokenModel?>? {
        TODO("Not yet implemented")
    }
//    override fun insertOrder(orderItemListModel: OrderItemListModel?):
//            Response<TransactionTokenModel?>?
//            {
       // var response: Response<TransactionTokenModel> = Response()
//        try {
//            response = orderDao?.insertOrder(orderItemListModel) ?:
//        } catch (e: GenericException) {
//            response = e.getResponse() as Response<TransactionTokenModel>
//        } catch (e: Exception) {
//            System.err.println(e.javaClass.name + ": " + e.message)
//        }
//        return response
//    }

    override fun placeOrder(orderId: Int?): Response<String?>? {
        val response: Response<String?>? = orderDao?.placeOrder(orderId)
        if (response != null) {
            if (response.getCode().equals(ErrorLog.CodeSuccess)) {
                notifyDao?.notifyOrderStatusToSeller(orderDao?.getOrderById(orderId))
            }
        }
        return response
    }

    override fun getOrderByUserId(
        userId: Int?,
        pageNum: Int?,
        pageCount: Int?
    ): Response<List<OrderItemListModel?>?>? {
        return orderDao?.getOrderByUserId(userId, pageNum, pageCount)
    }

    override fun getOrderBySearchQuery(
        shopId: Int?,
        searchItem: String?,
        pageNum: Int?,
        pageCount: Int?
    ): Response<List<OrderItemListModel?>?>? {
        return orderDao?.getOrderBySearchQuery(shopId, searchItem, pageNum, pageCount)
    }

    override fun getOrderByShopIdPagination(shopId: Int?, pageNum: Int?, pageCount: Int?): Response<List<OrderItemListModel?>?>? {
        val response: Response<List<OrderItemListModel?>?>? =
            orderDao?.getOrderByShopIdPagination(shopId, pageNum, pageCount)
        return orderDao?.getOrderByShopIdPagination(shopId, pageNum, pageCount)
    }

    override fun getOrderByShopId(shopId: Int?): Response<List<OrderItemListModel?>?>? {
        val response: Response<List<OrderItemListModel?>?>? = orderDao?.getOrderByShopId(shopId)
        return orderDao?.getOrderByShopId(shopId)
    }

    override fun getOrderById(id: Int?): Response<OrderItemListModel?>? {
        val response: Response<OrderItemListModel?>? = orderDao?.getOrderById(id)
        try {
            if (response != null) {
                if (response.getCode().equals(ErrorLog.CodeSuccess)) if (response != null) {
//                    response.getData().getTransactionModel()
//                        .getOrderModel().getUserModel().setNotificationToken(null)
                }
            }
        } catch (e: Exception) {
        }
        return response
    }

    override fun updateOrderRating(orderModel: OrderModel?): Response<String?>? {
        return orderDao?.updateOrderRating(orderModel)
    }

    override fun updateOrderStatus(orderModel: OrderModel?): Response<String?>? {
        val response: Response<String?>? = orderDao?.updateOrderStatus(orderModel)
        if (response != null) {
            if (response.getCode().equals(ErrorLog.CodeSuccess)) {
                if (orderModel != null) {
                    when (orderModel.getOrderStatus()) {
                        Enums.OrderStatus.CANCELLED_BY_USER -> notifyDao?.notifyOrderStatusToSeller(orderDao?.getOrderById(orderModel.getId()))
                        else -> notifyDao?.notifyOrderStatus(orderDao?.getOrderById(orderModel.getId()))
                    }
                }
            }
        }
        return response
    }
}
