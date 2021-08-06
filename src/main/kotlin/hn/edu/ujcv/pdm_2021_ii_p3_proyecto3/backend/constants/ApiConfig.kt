package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

object ApiConfig {
    const val EMPTY_QUOTES = ""

    object PlaceApi {
        const val BASE_URL = "/place"
        const val insertPlace = EMPTY_QUOTES
        const val getAllPlaces = EMPTY_QUOTES
    }

    object ItemApi {
        const val BASE_URL = "/menu"
        const val insertItem = EMPTY_QUOTES
        const val getItemsByShopId = "/shop/{shopId}"
        const val getItemsByName = "/{placeId}/{itemName}"
        const val updateItem = EMPTY_QUOTES
        const val deleteItemById = "/delete/{itemId}"
    }

    object OrderApi {
        const val BASE_URL = "/order"
        const val insertOrder = EMPTY_QUOTES
        const val placeOrder = "/place/{orderId}"
        const val getOrderByUserId = "/customer/{userId}/{pageNum}/{pageCount}"
        const val getOrderBySearchQuery = "/{shopId}/{searchItem}/{pageNum}/{pageCount}"
        const val getOrderByShopIdPagination = "/seller/{shopId}/{pageNum}/{pageCount}"
        const val getOrderByShopId = "/seller/{shopId}"
        const val getOrderById = "/{id}"
        const val updateOrderRating = "/rating"
        const val updateOrderStatus = "/status"
    }

    object UserApi {
        const val BASE_URL = "/user"
        const val loginRegisterCustomer = "/customer"
        const val verifySeller = "/seller"
        const val updateUser = EMPTY_QUOTES
        const val updateUserNotificationToken = "/notif"
        const val updateUserPlaceData = "/place"
        const val deleteSeller = "/seller/{shopId}/{userId}"
    }

    object NotifyApi {
        const val BASE_URL = "/notify"
        const val notifyUrl = "/url"
        const val notifyNewArrival = "/newArrivals"
    }

    object ShopApi {
        const val BASE_URL = "/shop"
        const val insertShop = EMPTY_QUOTES
        const val getShopsByPlaceId = "/place/{placeId}"
        const val getShopById = "/{shopId}"
        const val updateShopConfiguration = "/config"
        const val deleteShop = "/{shopId}"
    }
}