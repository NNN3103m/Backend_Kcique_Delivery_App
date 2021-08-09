package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

object Column {
    const val placeAddress = "place_address"
    const val placeName = "place_name"
    const val shopName = "shop_name"
    const val shopMobile = "shop_mobile"
    const val shopId = "shop_id"
    const val userName = "user_name"
    const val userMobile = "user_mobile"
    const val itemName = "item_name"
    const val itemPrice = "item_price"
    const val orderItemPrice = "order_item_price"
    const val searchQuery = "search_query"

    object PlaceColumn {
        const val tableName = "place"
        const val id = "id"
        const val name = "name"
        const val iconUrl = "icon_url"
        const val address = "address"
        const val isDelete = "is_delete"
    }

    object ConfigurationColumn {
        const val tableName = "configurations"
        const val shopId = "shop_id"
        const val merchantId = "merchant_id"
        const val deliveryPrice = "delivery_price"
        const val isDeliveryAvailable = "is_delivery_available"
        const val isOrderTaken = "is_order_taken"
    }

    object ItemColumn {
        const val tableName = "item"
        const val id = "id"
        const val name = "name"
        const val price = "price"
        const val photoUrl = "photo_url"
        const val category = "category"
        const val shopId = "shop_id"
        const val isAvailable = "is_available"
        const val isDelete = "is_delete"
    }

    object OrderColumn {
        const val tableName = "orders"
        const val id = "id"
        const val userId = "user_id"
        const val shopId = "shop_id"
        const val date = "date"
        const val status = "status"
        const val price = "price"
        const val deliveryPrice = "delivery_price"
        const val deliveryLocation = "delivery_location"
        const val cookingInfo = "cooking_info"
        const val rating = "rating"
        const val feedback = "feedback"
        const val secretKey = "secret_key"
    }

    object OrderStatusColumn {
        const val tableName = "orders_status"
        const val orderId = "order_id"
        const val status = "status"
        const val updatedTime = "updated_time"
    }

    object OrderItemColumn {
        const val tableName = "orders_item"
        const val orderId = "order_id"
        const val itemId = "item_id"
        const val quantity = "quantity"
        const val price = "price"
    }

    object RatingColumn {
        const val tableName = "rating"
        const val shopId = "shop_id"
        const val rating = "rating"
        const val userCount = "user_count"
    }

    object UserInviteColumn {
        const val tableName = "users_invite"
        const val mobile = "mobile"
        const val shopId = "shop_id"
        const val invitedAt = "invited_at"
        const val role = "role"
        const val isDelete = "is_delete"
    }

    object ShopColumn {
        const val tableName = "shop"
        const val id = "id"
        const val name = "name"
        const val photoUrl = "photo_url"
        const val coverUrls = "cover_urls"
        const val mobile = "mobile"
        const val placeId = "place_id"
        const val openingTime = "opening_time"
        const val closingTime = "closing_time"
        const val isDelete = "is_delete"
    }

    object TransactionColumn {
        const val tableName = "transactions"
        const val transactionId = "transaction_id"
        const val orderId = "order_id"
        const val bankTransactionId = "bank_transaction_id"
        const val currency = "currency"
        const val responseCode = "response_code"
        const val responseMessage = "response_message"
        const val gatewayName = "gateway_name"
        const val bankName = "bank_name"
        const val paymentMode = "payment_mode"
        const val checksumHash = "checksum_hash"
        const val date = "date"
    }

    object UserPlaceColumn {
        const val tableName = "users_place"
        const val userId = "user_id"
        const val placeId = "place_id"
    }

    object UserColumn {
        const val tableName = "users"
        const val id = "id"
        const val mobile = "mobile"
        const val name = "name"
        const val email = "email"
        const val oauthId = "oauth_id"
        const val notifToken = "notif_token"
        const val role = "role"
        const val isDelete = "is_delete"
    }

    object UserShopColumn {
        const val tableName = "users_shop"
        const val userId = "user_id"
        const val shopId = "shop_id"
    }

    /** */
    object ApplicationLogColumn {
        const val tableName = "application_log"
        const val requestType = "request_type"
        const val endpointUrl = "endpoint_url"
        const val requestHeader = "request_header"
        const val requestObject = "request_object"
        const val responseObject = "response_object"
        const val date = "date"
    }
}