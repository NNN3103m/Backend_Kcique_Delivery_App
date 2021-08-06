package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

class Enums {
    enum class OrderStatus {
        PENDING, TXN_FAILURE, PLACED, CANCELLED_BY_USER, ACCEPTED, CANCELLED_BY_SELLER, READY, OUT_FOR_DELIVERY, COMPLETED, DELIVERED, REFUND_INITIATED, REFUND_COMPLETED
    }

    enum class TransactionStatus {
        PENDING, TXN_FAILURE, TXN_SUCCESS, REFUND_COMPLETED
    }

    enum class Priority {
        LOW, MEDIUM, HIGH
    }

    enum class UserRole {
        CUSTOMER, SELLER, SHOP_OWNER, DELIVERY, SUPER_ADMIN
    }

    enum class NotificationType {
        URL, NEW_ARRIVAL, USER_ORDER_STATUS, SELLER_ORDER_STATUS
    }
}