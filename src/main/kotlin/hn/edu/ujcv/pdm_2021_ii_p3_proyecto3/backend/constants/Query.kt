package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

class Query {
    object AuditLogQuery {
        const val insertLog = Sql.INSERT_INTO + ApplicationLogColumn.tableName + Sql.LEFT_PARANTHESIS +
                ApplicationLogColumn.requestType + Sql.COMMA +
                ApplicationLogColumn.endpointUrl + Sql.COMMA +
                ApplicationLogColumn.requestHeader + Sql.COMMA +
                ApplicationLogColumn.requestObject + Sql.COMMA +
                ApplicationLogColumn.responseObject +
                Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + ApplicationLogColumn.requestType +
                Sql.COMMA_COLON + ApplicationLogColumn.endpointUrl +
                Sql.COMMA_COLON + ApplicationLogColumn.requestHeader +
                Sql.COMMA_COLON + ApplicationLogColumn.requestObject +
                Sql.COMMA_COLON + ApplicationLogColumn.responseObject +
                Sql.RIGHT_PARANTHESIS
    }

    object PlaceQuery {
        const val notDeleted = PlaceColumn.isDelete + " = 0"
        const val insertPlace = Sql.INSERT_INTO + PlaceColumn.tableName + Sql.LEFT_PARANTHESIS +
                PlaceColumn.name + Sql.COMMA +
                PlaceColumn.iconUrl + Sql.COMMA +
                PlaceColumn.address + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + PlaceColumn.name +
                Sql.COMMA_COLON + PlaceColumn.iconUrl +
                Sql.COMMA_COLON + PlaceColumn.address + Sql.RIGHT_PARANTHESIS
        const val getAllPlaces = Sql.SELECT +
                PlaceColumn.id + Sql.COMMA +
                PlaceColumn.name + Sql.COMMA +
                PlaceColumn.iconUrl + Sql.COMMA +
                PlaceColumn.address + Sql.FROM + PlaceColumn.tableName + Sql.WHERE +
                notDeleted +
                Sql.ORDER_BY + PlaceColumn.name + Sql.ASC

        //TODO: Issue #4 Zinger Admin API for Place
        const val updatePlace = Sql.UPDATE + PlaceColumn.tableName + Sql.SET +
                PlaceColumn.name + Sql.EQUAL_COLON + PlaceColumn.name + Sql.COMMA +
                PlaceColumn.iconUrl + Sql.EQUAL_COLON + PlaceColumn.iconUrl + Sql.COMMA +
                PlaceColumn.address + Sql.EQUAL_COLON + PlaceColumn.address + Sql.WHERE +
                PlaceColumn.id + Sql.EQUAL_COLON + PlaceColumn.id
        const val deletePlace = Sql.UPDATE + PlaceColumn.tableName + Sql.SET +
                PlaceColumn.isDelete + " = 1" + Sql.WHERE +
                PlaceColumn.id + Sql.EQUAL_COLON + PlaceColumn.id
    }

    object ItemQuery {
        const val notDeleted = ItemColumn.isDelete + " = 0"
        const val getItemsByShopId = Sql.SELECT +
                ItemColumn.id + Sql.COMMA +
                ItemColumn.name + Sql.COMMA +
                ItemColumn.price + Sql.COMMA +
                ItemColumn.photoUrl + Sql.COMMA +
                ItemColumn.category + Sql.COMMA +
                ItemColumn.shopId + Sql.COMMA +
                ItemColumn.isVeg + Sql.COMMA +
                ItemColumn.isAvailable + Sql.FROM + ItemColumn.tableName + Sql.WHERE +
                ItemColumn.shopId + Sql.EQUAL_COLON + ItemColumn.shopId + Sql.AND +
                notDeleted
        const val getItemsByName = Sql.SELECT +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.photoUrl + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.category + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.shopId + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                ItemColumn.tableName + Sql.DOT + ItemColumn.isAvailable + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.AS + Column.shopName + Sql.FROM + ItemColumn.tableName +
                Sql.INNER_JOIN + ShopColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.shopId + Sql.EQUALS + ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.AND +
                ShopColumn.tableName + Sql.DOT + ShopColumn.placeId + Sql.EQUAL_COLON + ShopColumn.placeId + Sql.WHERE +
                ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.LIKE + Sql.COLON + ItemColumn.name + Sql.AND +
                ItemColumn.tableName + Sql.DOT + notDeleted
        const val updateItem = Sql.UPDATE + ItemColumn.tableName + Sql.SET +
                ItemColumn.name + Sql.EQUAL_COLON + ItemColumn.name + Sql.COMMA +
                ItemColumn.price + Sql.EQUAL_COLON + ItemColumn.price + Sql.COMMA +
                ItemColumn.photoUrl + Sql.EQUAL_COLON + ItemColumn.photoUrl + Sql.COMMA +
                ItemColumn.category + Sql.EQUAL_COLON + ItemColumn.category + Sql.COMMA +
                ItemColumn.isVeg + Sql.EQUAL_COLON + ItemColumn.isVeg + Sql.COMMA +
                ItemColumn.isAvailable + Sql.EQUAL_COLON + ItemColumn.isAvailable + Sql.WHERE +
                ItemColumn.id + Sql.EQUAL_COLON + ItemColumn.id
        const val deleteItem = Sql.UPDATE + ItemColumn.tableName + Sql.SET +
                ItemColumn.isDelete + " = 1" + Sql.WHERE +
                ItemColumn.id + Sql.EQUAL_COLON + ItemColumn.id

        @JvmStatic
        fun getInsertItem(itemModelList: List<ItemModel?>): String {
            val insertItem = StringBuilder(Sql.INSERT_INTO + ItemColumn.tableName + Sql.LEFT_PARANTHESIS +
                    ItemColumn.name + Sql.COMMA +
                    ItemColumn.price + Sql.COMMA +
                    ItemColumn.photoUrl + Sql.COMMA +
                    ItemColumn.category + Sql.COMMA +
                    ItemColumn.shopId + Sql.COMMA +
                    ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.VALUES)
            for (i in itemModelList.indices) {
                insertItem.append(Sql.LEFT_PARANTHESIS)
                        .append(Sql.COLON).append(ItemColumn.name).append(i)
                        .append(Sql.COMMA_COLON).append(ItemColumn.price).append(i)
                        .append(Sql.COMMA_COLON).append(ItemColumn.photoUrl).append(i)
                        .append(Sql.COMMA_COLON).append(ItemColumn.category).append(i)
                        .append(Sql.COMMA_COLON).append(ItemColumn.shopId).append(i)
                        .append(Sql.COMMA_COLON).append(ItemColumn.isVeg).append(i)
                        .append(Sql.RIGHT_PARANTHESIS)
                if (i < itemModelList.size - 1) insertItem.append(Sql.COMMA)
            }
            return insertItem.toString()
        }
    }

    object OrderQuery {
        const val pageNum = "pageNum"
        const val pageCount = "pageCount"
        const val getOrderByUserId = Sql.SELECT +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.date + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.price + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.shopName + Sql.COMMA +
                Sql.LHS + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.shopMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderItemColumn.quantity + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.orderItemPrice + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderColumn.status + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderStatusColumn.updatedTime + Sql.FROM + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.price + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.AS + Column.shopName + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.AS + Column.shopMobile + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemName + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemPrice + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.AS + ItemColumn.isVeg + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.quantity + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderItemColumn.quantity + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.orderItemPrice + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + TransactionColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + TransactionColumn.tableName + Sql.DOT + TransactionColumn.orderId + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.userId + Sql.EQUAL_COLON + UserColumn.id +
                Sql.INNER_JOIN + OrderItemColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.orderId +
                Sql.INNER_JOIN + ItemColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.itemId +
                Sql.INNER_JOIN + ShopColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.shopId +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.LHS + Sql.COMMA + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.status + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.status + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.updatedTime + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.updatedTime + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + OrderStatusColumn.tableName + Sql.ON +
                OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.orderId + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.userId + Sql.EQUAL_COLON + UserColumn.id +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.RHS + Sql.WHERE +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.EQUALS + Sql.RHS + Sql.DOT + OrderColumn.id
        @JvmField
        val getOrderByShopIdPaginated = Sql.SELECT +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.date + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.price + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderItemColumn.quantity + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.orderItemPrice + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderColumn.status + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderStatusColumn.updatedTime + Sql.FROM + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.price + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.AS + Column.userName + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.AS + Column.userMobile + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemName + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemPrice + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.AS + ItemColumn.isVeg + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.quantity + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderItemColumn.quantity + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.orderItemPrice + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + TransactionColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + TransactionColumn.tableName + Sql.DOT + TransactionColumn.orderId + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_USER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_INITIATED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.DELIVERED.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.INNER_JOIN + OrderItemColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.orderId +
                Sql.INNER_JOIN + ItemColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.itemId +
                Sql.INNER_JOIN + UserColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.userId +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.LHS + Sql.COMMA + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.status + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.status + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.updatedTime + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.updatedTime + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + OrderStatusColumn.tableName + Sql.ON +
                OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.orderId + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_USER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_INITIATED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.DELIVERED.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.RHS + Sql.WHERE +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.EQUALS + Sql.RHS + Sql.DOT + OrderColumn.id
        @JvmField
        val getOrderByShopId = Sql.SELECT +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.date + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.price + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderItemColumn.quantity + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.orderItemPrice + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderColumn.status + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderStatusColumn.updatedTime + Sql.FROM + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.price + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.AS + Column.userName + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.AS + Column.userMobile + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemName + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemPrice + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.AS + ItemColumn.isVeg + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.quantity + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderItemColumn.quantity + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.orderItemPrice + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + TransactionColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + TransactionColumn.tableName + Sql.DOT + TransactionColumn.orderId + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.PLACED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.ACCEPTED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.READY.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.OUT_FOR_DELIVERY.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.INNER_JOIN + OrderItemColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.orderId +
                Sql.INNER_JOIN + ItemColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.itemId +
                Sql.INNER_JOIN + UserColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.userId +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.LHS + Sql.COMMA + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.status + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.status + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.updatedTime + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.updatedTime + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + OrderStatusColumn.tableName + Sql.ON +
                OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.orderId + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.PLACED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.ACCEPTED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.READY.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.OUT_FOR_DELIVERY.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.RHS + Sql.WHERE +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.EQUALS + Sql.RHS + Sql.DOT + OrderColumn.id
        @JvmField
        val getOrderByFilterPaginated = Sql.SELECT +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.date + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.price + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderItemColumn.quantity + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.orderItemPrice + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderColumn.status + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderStatusColumn.updatedTime + Sql.FROM + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.price + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.AS + Column.userName + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.AS + Column.userMobile + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemName + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemPrice + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.AS + ItemColumn.isVeg + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.quantity + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderItemColumn.quantity + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.orderItemPrice + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + TransactionColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + TransactionColumn.tableName + Sql.DOT + TransactionColumn.orderId + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_USER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_INITIATED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.DELIVERED.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.INNER_JOIN + OrderItemColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.orderId +
                Sql.INNER_JOIN + ItemColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.itemId +
                Sql.INNER_JOIN + UserColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.userId + Sql.WHERE +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.LIKE + Sql.COLON + Column.searchQuery + Sql.OR +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.LIKE + Sql.COLON + Column.searchQuery + Sql.OR +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.LIKE + Sql.COLON + Column.searchQuery +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.LHS + Sql.COMMA + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.status + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.status + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.updatedTime + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.updatedTime + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + OrderStatusColumn.tableName + Sql.ON +
                OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.orderId + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.shopId + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.CANCELLED_BY_USER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_INITIATED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.REFUND_COMPLETED.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + OrderStatus.DELIVERED.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.INNER_JOIN + UserColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.userId + Sql.WHERE +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.LIKE + Sql.COLON + Column.searchQuery + Sql.OR +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.LIKE + Sql.COLON + Column.searchQuery + Sql.OR +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.LIKE + Sql.COLON + Column.searchQuery +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id +
                Sql.ORDER_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.DESC +
                Sql.LIMIT + Sql.COLON + pageCount + Sql.OFFSET + Sql.COLON + pageNum + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.RHS + Sql.WHERE +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.EQUALS + Sql.RHS + Sql.DOT + OrderColumn.id
        const val getOrderById = Sql.SELECT +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.date + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.price + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                Sql.LHS + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userName + Sql.COMMA +
                Sql.LHS + Sql.DOT + UserColumn.notifToken + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.userMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.shopName + Sql.COMMA +
                Sql.LHS + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.shopMobile + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.shopId + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemName + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.itemPrice + Sql.COMMA +
                Sql.LHS + Sql.DOT + ItemColumn.isVeg + Sql.COMMA +
                Sql.LHS + Sql.DOT + OrderItemColumn.quantity + Sql.COMMA +
                Sql.LHS + Sql.DOT + Column.orderItemPrice + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderColumn.status + Sql.COMMA +
                Sql.RHS + Sql.DOT + OrderStatusColumn.updatedTime + Sql.FROM + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.date + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.price + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryPrice + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.deliveryLocation + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.cookingInfo + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.rating + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.feedback + Sql.COMMA +
                OrderColumn.tableName + Sql.DOT + OrderColumn.secretKey + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.paymentMode + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.AS + Column.userName + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.notifToken + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.AS + Column.userMobile + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.AS + Column.shopId + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.AS + Column.shopName + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.AS + Column.shopMobile + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.name + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemName + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.itemPrice + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + ItemColumn.tableName + Sql.DOT + ItemColumn.isVeg + Sql.RIGHT_PARANTHESIS + Sql.AS + ItemColumn.isVeg + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.quantity + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderItemColumn.quantity + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.AS + Column.orderItemPrice + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + TransactionColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + TransactionColumn.tableName + Sql.DOT + TransactionColumn.orderId + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUAL_COLON + OrderColumn.id +
                Sql.INNER_JOIN + OrderItemColumn.tableName + Sql.ON +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.orderId +
                Sql.INNER_JOIN + ItemColumn.tableName + Sql.ON +
                ItemColumn.tableName + Sql.DOT + ItemColumn.id + Sql.EQUALS + OrderItemColumn.tableName + Sql.DOT + OrderItemColumn.itemId +
                Sql.INNER_JOIN + UserColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.userId +
                Sql.INNER_JOIN + ShopColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.shopId +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                TransactionColumn.tableName + Sql.DOT + TransactionColumn.transactionId + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.LHS + Sql.COMMA + Sql.LEFT_PARANTHESIS + Sql.SELECT +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.status + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.status + Sql.COMMA +
                Sql.GROUP_CONCAT + Sql.LEFT_PARANTHESIS + OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.updatedTime + Sql.RIGHT_PARANTHESIS + Sql.AS + OrderStatusColumn.updatedTime + Sql.FROM + OrderColumn.tableName +
                Sql.INNER_JOIN + OrderStatusColumn.tableName + Sql.ON +
                OrderStatusColumn.tableName + Sql.DOT + OrderStatusColumn.orderId + Sql.EQUALS + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.AND +
                OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.EQUAL_COLON + OrderColumn.id +
                Sql.GROUP_BY + OrderColumn.tableName + Sql.DOT + OrderColumn.id + Sql.RIGHT_PARANTHESIS + Sql.AS + Sql.RHS + Sql.WHERE +
                Sql.LHS + Sql.DOT + OrderColumn.id + Sql.EQUALS + Sql.RHS + Sql.DOT + OrderColumn.id
        const val getOrderPriceById = Sql.SELECT +
                OrderColumn.id + Sql.COMMA +
                OrderColumn.price + Sql.FROM + OrderColumn.tableName + Sql.WHERE +
                OrderColumn.id + Sql.EQUAL_COLON + OrderColumn.id
        const val updateOrderRating = Sql.UPDATE + OrderColumn.tableName + Sql.SET +
                OrderColumn.rating + Sql.EQUAL_COLON + OrderColumn.rating + Sql.COMMA +
                OrderColumn.feedback + Sql.EQUAL_COLON + OrderColumn.feedback + Sql.WHERE +
                OrderColumn.id + Sql.EQUAL_COLON + OrderColumn.id

        @JvmStatic
        fun getInsertOrder(orderItemModelList: List<OrderItemModel?>): String {
            val insertOrderItem = StringBuilder(Sql.INSERT_INTO + OrderItemColumn.tableName + Sql.LEFT_PARANTHESIS +
                    OrderItemColumn.orderId + Sql.COMMA +
                    OrderItemColumn.itemId + Sql.COMMA +
                    OrderItemColumn.quantity + Sql.COMMA +
                    OrderItemColumn.price + Sql.RIGHT_PARANTHESIS + Sql.VALUES)
            for (i in orderItemModelList.indices) {
                insertOrderItem.append(Sql.LEFT_PARANTHESIS)
                        .append(Sql.COLON).append(OrderItemColumn.orderId).append(i)
                        .append(Sql.COMMA_COLON).append(OrderItemColumn.itemId).append(i)
                        .append(Sql.COMMA_COLON).append(OrderItemColumn.quantity).append(i)
                        .append(Sql.COMMA_COLON).append(OrderItemColumn.price).append(i)
                        .append(Sql.RIGHT_PARANTHESIS)
                if (i < orderItemModelList.size - 1) insertOrderItem.append(Sql.COMMA)
            }
            return insertOrderItem.toString()
        }

        @JvmStatic
        fun getOrderByStatus(orderStatusList: List<OrderStatus>): String {
            val getOrderByStatus = StringBuilder(Sql.SELECT +
                    OrderColumn.id + Sql.COMMA +
                    OrderColumn.date + Sql.FROM + OrderColumn.tableName + Sql.WHERE +
                    OrderColumn.status + Sql.IN + Sql.LEFT_PARANTHESIS)
            for (i in orderStatusList.indices) {
                getOrderByStatus.append(Sql.SINGLE_QUOTE).append(orderStatusList[i].name).append(Sql.SINGLE_QUOTE)
                if (i < orderStatusList.size - 1) getOrderByStatus.append(Sql.COMMA) else getOrderByStatus.append(Sql.RIGHT_PARANTHESIS)
            }
            return getOrderByStatus.toString()
        }
    }

    object UserInviteQuery {
        const val notDeleted = UserInviteColumn.isDelete + " = 0"
        const val inviteSeller = Sql.INSERT_INTO + UserInviteColumn.tableName + Sql.LEFT_PARANTHESIS +
                UserInviteColumn.mobile + Sql.COMMA +
                UserInviteColumn.role + Sql.COMMA +
                UserInviteColumn.shopId + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + UserInviteColumn.mobile +
                Sql.COMMA_COLON + UserInviteColumn.role +
                Sql.COMMA_COLON + UserInviteColumn.shopId + Sql.RIGHT_PARANTHESIS
        const val verifyInvite = Sql.SELECT +
                UserInviteColumn.role + Sql.FROM + UserInviteColumn.tableName + Sql.WHERE +
                UserInviteColumn.mobile + Sql.EQUAL_COLON + UserInviteColumn.mobile + Sql.AND +
                UserInviteColumn.shopId + Sql.EQUAL_COLON + UserInviteColumn.shopId + Sql.AND +
                notDeleted + Sql.AND +
                Sql.TIMESTAMPDIFF + Sql.LEFT_PARANTHESIS + Sql.MINUTE + Sql.COMMA + UserInviteColumn.invitedAt + Sql.COMMA + Sql.CURRENT_TIMESTAMP + Sql.RIGHT_PARANTHESIS + Sql.LESS_THAN + 15 +
                Sql.ORDER_BY + UserInviteColumn.invitedAt + Sql.DESC + Sql.LIMIT + 1
        const val deleteInvite = Sql.UPDATE + UserInviteColumn.tableName + Sql.SET +
                UserInviteColumn.isDelete + " = 1" + Sql.WHERE +
                UserInviteColumn.mobile + Sql.EQUAL_COLON + UserInviteColumn.mobile + Sql.AND +
                UserInviteColumn.role + Sql.EQUAL_COLON + UserInviteColumn.role + Sql.AND +
                UserInviteColumn.shopId + Sql.EQUAL_COLON + UserInviteColumn.shopId
    }

    object ShopQuery {
        const val notDeleted = ShopColumn.isDelete + " = 0"
        const val insertConfiguration = Sql.INSERT_INTO + ConfigurationColumn.tableName + Sql.LEFT_PARANTHESIS +
                ConfigurationColumn.shopId + Sql.COMMA +
                ConfigurationColumn.merchantId + Sql.COMMA +
                ConfigurationColumn.deliveryPrice + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + ConfigurationColumn.shopId +
                Sql.COMMA_COLON + ConfigurationColumn.merchantId +
                Sql.COMMA_COLON + ConfigurationColumn.deliveryPrice + Sql.RIGHT_PARANTHESIS
        const val getShopByPlaceId = Sql.SELECT +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.coverUrls + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.openingTime + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.closingTime + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.merchantId + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.deliveryPrice + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isDeliveryAvailable + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isOrderTaken + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.rating + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.userCount + Sql.FROM + ShopColumn.tableName +
                Sql.INNER_JOIN + ConfigurationColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.placeId + Sql.EQUAL_COLON + ShopColumn.placeId + Sql.AND +
                notDeleted + Sql.AND +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.shopId +
                Sql.INNER_JOIN + RatingColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + RatingColumn.tableName + Sql.DOT + RatingColumn.shopId
        const val getShopById = Sql.SELECT +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.coverUrls + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.openingTime + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.closingTime + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.merchantId + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.deliveryPrice + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isDeliveryAvailable + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isOrderTaken + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.rating + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.userCount + Sql.FROM + ShopColumn.tableName +
                Sql.INNER_JOIN + ConfigurationColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUAL_COLON + ShopColumn.id + Sql.AND +
                notDeleted + Sql.AND +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.shopId +
                Sql.INNER_JOIN + RatingColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + RatingColumn.tableName + Sql.DOT + RatingColumn.shopId
        const val updateShop = Sql.UPDATE + ShopColumn.tableName + Sql.COMMA + ConfigurationColumn.tableName + Sql.SET +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.EQUAL_COLON + ShopColumn.name + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.EQUAL_COLON + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.coverUrls + Sql.EQUAL_COLON + ShopColumn.coverUrls + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.EQUAL_COLON + ShopColumn.mobile + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.openingTime + Sql.EQUAL_COLON + ShopColumn.openingTime + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.closingTime + Sql.EQUAL_COLON + ShopColumn.closingTime + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.merchantId + Sql.EQUAL_COLON + ConfigurationColumn.merchantId + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.deliveryPrice + Sql.EQUAL_COLON + ConfigurationColumn.deliveryPrice + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isDeliveryAvailable + Sql.EQUAL_COLON + ConfigurationColumn.isDeliveryAvailable + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isOrderTaken + Sql.EQUAL_COLON + ConfigurationColumn.isOrderTaken + Sql.WHERE +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.shopId + Sql.EQUALS + ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.AND +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUAL_COLON + ShopColumn.id
        const val deleteShop = Sql.UPDATE + ShopColumn.tableName + Sql.SET +
                ShopColumn.isDelete + " = 1" + Sql.WHERE +
                ShopColumn.id + Sql.EQUAL_COLON + ShopColumn.id
    }

    object TransactionQuery {
        const val insertTransaction = Sql.INSERT_INTO + TransactionColumn.tableName + Sql.LEFT_PARANTHESIS +
                TransactionColumn.transactionId + Sql.COMMA +
                TransactionColumn.orderId + Sql.COMMA +
                TransactionColumn.bankTransactionId + Sql.COMMA +
                TransactionColumn.currency + Sql.COMMA +
                TransactionColumn.responseCode + Sql.COMMA +
                TransactionColumn.responseMessage + Sql.COMMA +
                TransactionColumn.gatewayName + Sql.COMMA +
                TransactionColumn.bankName + Sql.COMMA +
                TransactionColumn.paymentMode + Sql.COMMA +
                TransactionColumn.checksumHash + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + TransactionColumn.transactionId +
                Sql.COMMA_COLON + TransactionColumn.orderId +
                Sql.COMMA_COLON + TransactionColumn.bankTransactionId +
                Sql.COMMA_COLON + TransactionColumn.currency +
                Sql.COMMA_COLON + TransactionColumn.responseCode +
                Sql.COMMA_COLON + TransactionColumn.responseMessage +
                Sql.COMMA_COLON + TransactionColumn.gatewayName +
                Sql.COMMA_COLON + TransactionColumn.bankName +
                Sql.COMMA_COLON + TransactionColumn.paymentMode +
                Sql.COMMA_COLON + TransactionColumn.checksumHash + Sql.RIGHT_PARANTHESIS
        const val updateTransaction = Sql.UPDATE + TransactionColumn.tableName + Sql.SET +
                TransactionColumn.responseCode + Sql.EQUAL_COLON + TransactionColumn.responseCode + Sql.COMMA +
                TransactionColumn.responseMessage + Sql.EQUAL_COLON + TransactionColumn.responseMessage + Sql.COMMA +
                TransactionColumn.date + Sql.EQUALS + Sql.CURRENT_TIMESTAMP + Sql.WHERE +
                TransactionColumn.transactionId + Sql.EQUAL_COLON + TransactionColumn.transactionId
    }

    object UserPlaceQuery {
        const val insertUserPlace = Sql.INSERT_INTO + UserPlaceColumn.tableName + Sql.LEFT_PARANTHESIS +
                UserPlaceColumn.userId + Sql.COMMA +
                UserPlaceColumn.placeId + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + UserPlaceColumn.userId +
                Sql.COMMA_COLON + UserPlaceColumn.placeId + Sql.RIGHT_PARANTHESIS
        const val updatePlaceById = Sql.UPDATE + UserPlaceColumn.tableName + Sql.SET +
                UserPlaceColumn.placeId + Sql.EQUAL_COLON + UserPlaceColumn.placeId + Sql.WHERE +
                UserPlaceColumn.userId + Sql.EQUAL_COLON + UserPlaceColumn.userId
    }

    object UserQuery {
        const val notDeleted = UserColumn.isDelete + " = 0"
        const val getUserIdByMobile = Sql.SELECT +
                UserColumn.id + Sql.FROM + UserColumn.tableName + Sql.WHERE +
                UserColumn.mobile + Sql.EQUAL_COLON + UserColumn.mobile
        val getSellerByShopId = Sql.SELECT +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.email + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.FROM + UserColumn.tableName +
                Sql.INNER_JOIN + UserShopColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + UserShopColumn.tableName + Sql.DOT + UserShopColumn.userId + Sql.AND +
                UserColumn.tableName + Sql.DOT + notDeleted + Sql.AND +
                UserShopColumn.tableName + Sql.DOT + UserShopColumn.shopId + Sql.EQUAL_COLON + UserShopColumn.shopId + Sql.AND +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.IN + Sql.LEFT_PARANTHESIS + Sql.SINGLE_QUOTE + UserRole.SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + UserRole.DELIVERY.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS +
                Sql.UNION + Sql.SELECT +
                "0" + Sql.COMMA +
                Sql.SINGLE_QUOTE + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + Sql.SINGLE_QUOTE + Sql.COMMA +
                UserInviteColumn.mobile + Sql.COMMA +
                UserInviteColumn.role + Sql.FROM + UserInviteColumn.tableName + Sql.WHERE +
                UserInviteColumn.shopId + Sql.EQUAL_COLON + UserShopColumn.shopId + Sql.AND +
                UserInviteQuery.notDeleted + Sql.AND +
                Sql.TIMESTAMPDIFF + Sql.LEFT_PARANTHESIS + Sql.MINUTE + Sql.COMMA + UserInviteColumn.invitedAt + Sql.COMMA + Sql.CURRENT_TIMESTAMP + Sql.RIGHT_PARANTHESIS + Sql.LESS_THAN + 15 + Sql.AND +
                UserInviteColumn.role + Sql.IN + Sql.LEFT_PARANTHESIS + Sql.SINGLE_QUOTE + UserRole.SELLER.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + UserRole.DELIVERY.name + Sql.SINGLE_QUOTE + Sql.COMMA +
                Sql.SINGLE_QUOTE + UserRole.SHOP_OWNER.name + Sql.SINGLE_QUOTE + Sql.RIGHT_PARANTHESIS
        const val updateUser = Sql.UPDATE + UserColumn.tableName + Sql.SET +
                UserColumn.name + Sql.EQUAL_COLON + UserColumn.name + Sql.COMMA +
                UserColumn.oauthId + Sql.EQUAL_COLON + UserColumn.oauthId + Sql.COMMA +
                UserColumn.email + Sql.EQUAL_COLON + UserColumn.email + Sql.COMMA +
                UserColumn.mobile + Sql.EQUAL_COLON + UserColumn.mobile + Sql.WHERE +
                UserColumn.id + Sql.EQUAL_COLON + UserColumn.id
        const val updateUserNotificationToken = Sql.UPDATE + UserColumn.tableName + Sql.SET +
                UserColumn.notifToken + Sql.EQUAL_COLON + UserColumn.notifToken + Sql.WHERE +
                UserColumn.id + Sql.EQUAL_COLON + UserColumn.id
        const val updateRole = Sql.UPDATE + UserColumn.tableName + Sql.SET +
                UserColumn.role + Sql.EQUAL_COLON + UserColumn.role + Sql.WHERE +
                UserColumn.id + Sql.EQUAL_COLON + UserColumn.id
        const val loginUserByMobileOauth = Sql.SELECT +
                UserColumn.id + Sql.COMMA +
                UserColumn.name + Sql.COMMA +
                UserColumn.email + Sql.COMMA +
                UserColumn.role + Sql.FROM + UserColumn.tableName + Sql.WHERE +
                UserColumn.mobile + Sql.EQUAL_COLON + UserColumn.mobile + Sql.AND +
                UserColumn.oauthId + Sql.EQUAL_COLON + UserColumn.oauthId + Sql.AND +
                notDeleted
        const val customerLogin = Sql.SELECT +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.email + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.COMMA +
                PlaceColumn.tableName + Sql.DOT + PlaceColumn.id + Sql.AS + UserPlaceColumn.placeId + Sql.COMMA +
                PlaceColumn.tableName + Sql.DOT + PlaceColumn.name + Sql.AS + Column.placeName + Sql.COMMA +
                PlaceColumn.tableName + Sql.DOT + PlaceColumn.iconUrl + Sql.COMMA +
                PlaceColumn.tableName + Sql.DOT + PlaceColumn.address + Sql.AS + Column.placeAddress + Sql.FROM + UserColumn.tableName +
                Sql.INNER_JOIN + UserPlaceColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + UserPlaceColumn.tableName + Sql.DOT + UserPlaceColumn.userId + Sql.AND +
                UserColumn.tableName + Sql.DOT + notDeleted +
                Sql.INNER_JOIN + PlaceColumn.tableName + Sql.ON +
                PlaceColumn.tableName + Sql.DOT + PlaceColumn.id + Sql.EQUALS + UserPlaceColumn.tableName + Sql.DOT + UserPlaceColumn.placeId + Sql.AND +
                PlaceColumn.tableName + Sql.DOT + PlaceQuery.notDeleted + Sql.WHERE +
                UserColumn.mobile + Sql.EQUAL_COLON + UserColumn.mobile + Sql.AND +
                UserColumn.oauthId + Sql.EQUAL_COLON + UserColumn.oauthId
        @JvmField
        val sellerLogin = Sql.SELECT +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.name + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.email + Sql.COMMA +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.AS + UserShopColumn.shopId + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.name + Sql.AS + Column.shopName + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.mobile + Sql.AS + Column.shopMobile + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.photoUrl + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.coverUrls + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.openingTime + Sql.COMMA +
                ShopColumn.tableName + Sql.DOT + ShopColumn.closingTime + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.merchantId + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.deliveryPrice + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isDeliveryAvailable + Sql.COMMA +
                ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.isOrderTaken + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.rating + Sql.COMMA +
                RatingColumn.tableName + Sql.DOT + RatingColumn.userCount + Sql.FROM + UserColumn.tableName +
                Sql.INNER_JOIN + UserShopColumn.tableName + Sql.ON +
                UserColumn.tableName + Sql.DOT + UserColumn.id + Sql.EQUALS + UserShopColumn.tableName + Sql.DOT + UserShopColumn.userId + Sql.AND +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.NOT_EQUALS + Sql.SINGLE_QUOTE + UserRole.CUSTOMER.name + Sql.SINGLE_QUOTE + Sql.AND +
                UserColumn.tableName + Sql.DOT + notDeleted +
                Sql.INNER_JOIN + ShopColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + UserShopColumn.tableName + Sql.DOT + UserShopColumn.shopId + Sql.AND +
                ShopColumn.tableName + Sql.DOT + ShopQuery.notDeleted +
                Sql.INNER_JOIN + ConfigurationColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + ConfigurationColumn.tableName + Sql.DOT + ConfigurationColumn.shopId +
                Sql.INNER_JOIN + RatingColumn.tableName + Sql.ON +
                ShopColumn.tableName + Sql.DOT + ShopColumn.id + Sql.EQUALS + RatingColumn.tableName + Sql.DOT + RatingColumn.shopId + Sql.WHERE +
                UserColumn.tableName + Sql.DOT + UserColumn.mobile + Sql.EQUAL_COLON + UserColumn.mobile + Sql.AND +
                UserColumn.tableName + Sql.DOT + UserColumn.oauthId + Sql.EQUAL_COLON + UserColumn.oauthId + Sql.AND +
                UserColumn.tableName + Sql.DOT + UserColumn.role + Sql.NOT_EQUALS + Sql.SINGLE_QUOTE + UserRole.CUSTOMER.name + Sql.SINGLE_QUOTE
        const val validateUser = Sql.SELECT +
                UserColumn.id + Sql.FROM + UserColumn.tableName + Sql.WHERE +
                UserColumn.id + Sql.EQUAL_COLON + UserColumn.id + Sql.AND +
                UserColumn.oauthId + Sql.EQUAL_COLON + UserColumn.oauthId + Sql.AND +
                UserColumn.role + Sql.EQUAL_COLON + UserColumn.role + Sql.AND +
                notDeleted
    }

    object UserShopQuery {
        const val insertUserShop = Sql.INSERT_INTO + UserShopColumn.tableName + Sql.LEFT_PARANTHESIS +
                UserShopColumn.userId + Sql.COMMA +
                UserShopColumn.shopId + Sql.RIGHT_PARANTHESIS + Sql.VALUES + Sql.LEFT_PARANTHESIS +
                Sql.COLON + UserShopColumn.userId +
                Sql.COMMA_COLON + UserShopColumn.shopId + Sql.RIGHT_PARANTHESIS
        const val updateShopById = Sql.UPDATE + UserShopColumn.tableName + Sql.SET +
                UserShopColumn.shopId + Sql.EQUAL_COLON + UserShopColumn.shopId + Sql.WHERE +
                UserShopColumn.userId + Sql.EQUAL_COLON + UserShopColumn.userId
    }
}