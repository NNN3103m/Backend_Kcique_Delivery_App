package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

object ErrorLog {
    const val CodeFailure = 0
    const val CodeSuccess = 1
    const val CodeEmpty = 2
    const val MissingRequestHeader = "Missing Request Header"
    const val InvalidHeader = "Invalid Header Values"
    const val UnAuthorizedAccess = "Unauthorized Access"
    const val Success = "Success"
    const val Failure = "Failure"
    const val UserDetailNotAvailable = "User detail not available"
    const val UserHasBeenBlocked = "User has been blocked"
    const val PlaceDetailNotAvailable = "Place detail not available"
    const val ShopDetailNotAvailable = "No shops found in this place"
    const val OrderDetailNotAvailable = "Order detail not available"
    const val ItemsNotAvailable = "Some Items are not available"
    const val DeliveryOptionNotAvailable = "Delivery Option not available"
    const val UserDetailNotUpdated = "Profile not updated"
    const val NotificationTokenNotUpdated = "Notification Token Not Updated"
    const val ConfigurationDetailNotUpdated = "Configuration detail not updated"
    const val ShopDetailNotUpdated = "Shop detail not updated"
    const val PlaceDetailNotUpdated = "Place detail not updated"
    const val TransactionDetailNotUpdated = "Transaction detail not updated"
    const val OrderDetailNotUpdated = "Unable to place order"
    const val OrderItemDetailNotUpdated = "Unable to place order"
    const val ItemDetailNotUpdated = "Unable to add or update current item"
    const val UnableToDeleteSeller = "Unable to delete seller"
    const val ShopDetailNotDeleted = "Unable to delete shop"
    const val InvalidOrderStatus = "Invalid Order status"
    const val SecretKeyMismatch = "Invalid secret key"
    const val OrderPriceMismatch = "Order price mismatch"
    const val RestaurantNotAcceptingOrders = "Restaurant not accepting orders"
    const val TransactionTokenNotAvailable = "Transaction Token Not Available"

    /** */ /* Place Controller Error Code 1100-1150
     *
     *   CE -> Catch Exception
     * */
    const val CDNU1100 = 1100
    const val CE1101 = 1101
    const val CDNA1102 = 1102
    const val CE1103 = 1103
    const val CE1104 = 1104
    const val CE1105 = 1105
    const val CE1106 = 1106
    const val CE1107 = 1107
    const val CE1108 = 1108
    const val CE1109 = 1109

    /** */ // User Controller Error Code 1151-1200
    const val UDNU1151 = 1151
    const val CE1152 = 1152
    const val UDNU1153 = 1153
    const val CE1154 = 1154
    const val UDNA1155 = 1155
    const val ODNU1156 = 1156
    const val UDNU1157 = 1157
    const val UDNU1158 = 1158
    const val NTNU1159 = 1159
    const val UDNU1160 = 1160
    const val CE1161 = 1161
    const val UDND1162 = 1162
    const val PDNA1163 = 1163
    const val PDNU1164 = 1164
    const val UDNU1165 = 1165
    const val IE1166 = 1166
    const val ODNA1167 = 1167
    const val SDNA1168 = 1168

    /** */ // Item Controller Error Code 1200-1250
    const val IDNU1201 = 1201
    const val CE1202 = 1202
    const val IDNA1203 = 1203
    const val CE1204 = 1204
    const val IDNA1205 = 1205
    const val CE1206 = 1206
    const val IDNU1207 = 1207
    const val CE1208 = 1208
    const val CE1209 = 1209
    const val IDNU1210 = 1210
    const val IDNU1211 = 1211
    const val CE1212 = 1212
    const val CE1213 = 1213
    const val SDNU1214 = 1214
    const val SDNU1215 = 1215

    /** */ // Shop Controller Error Code 1251-1260
    const val SDNU1251 = 1251
    const val CDNU1252 = 1252
    const val CE1253 = 1253
    const val CE1254 = 1254
    const val CE1255 = 1255
    const val SDNA1256 = 1256
    const val SDND1257 = 1257
    const val CE1258 = 1258
    const val CE1259 = 1259
    const val CDNU1260 = 1260

    /** */ // Order Controller Error Code 1261-1300
    const val CE1261 = 1261
    const val UDNA1262 = 1262
    const val DONA1263 = 1263
    const val TDNU1264 = 1264
    const val SDNA1265 = 1265
    const val RNAOC1266 = 1266
    const val CE1267 = 1267
    const val CE1268 = 1268
    const val CE1269 = 1269
    const val CE1270 = 1270
    const val TTNA1271 = 1271
    const val SDNA1272 = 1272
    const val OIDNA1273 = 1273
    const val CE1274 = 1274
    const val ODNU1275 = 1275
    const val ODNA1276 = 1276
    const val UDNA1277 = 1277
    const val CE1278 = 1278
    const val CE1279 = 1279
    const val ODNU1280 = 1280
    const val SKM1281 = 1281
    const val IOS1282 = 1282
    const val CE1283 = 1283
    const val CE1284 = 1284
    const val ODNU1285 = 1285
    const val CE1286 = 1286
    const val ODNA1287 = 1287
    const val CE1289 = 1289
    const val UDNA1290 = 1290
    const val ODNA1291 = 1291
    const val TDNA1292 = 1292
    const val UDNA1293 = 1293
    const val SDNA1294 = 1294
    const val ODNU1295 = 1295
    const val INA1296 = 1296
    const val OIDNA1297 = 1297
    const val OIDNA1298 = 1298
    const val ODNA1299 = 1299
    const val OPM1300 = 1300
    const val OIDNU301 = 1301
}