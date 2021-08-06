package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

object Constant {
    const val deliveryOrderFlag = "D"
    const val pickUpOrderFlag = "P"
    const val transactionFlag = "T"
    const val refundFlag = "R"
    const val notificationTitle = "title"
    const val notificationMessage = "message"
    const val notificationType = "type"
    const val notificationPayload = "payload"
    const val globalNotificationTopic = "global"

    object VerifyPricingProcedure {
        const val procedureName = "verify_pricing"

        // I/P parameters
        const val itemList = "item_list"
        const val shopId = "s_id"
        const val orderType = "order_type"

        // O/P parameters
        const val totalPrice = "total_price"
        const val merchantId = "m_id"
    }

    object OrderStatusUpdate {
        const val procedureName = "order_status_update"

        // I/P parameters
        const val orderId = "o_id"
        const val newStatus = "new_status"
        const val newSecretKey = "new_secret_key"

        // O/P parameters
        const val result = "result"
    }
}