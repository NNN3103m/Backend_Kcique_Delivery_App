package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums

class UserShopModel {
    var userModel: UserModel
    var shopModel: ShopModel
    var userRole: Enums.UserRole? = null
    override fun toString(): String {
        return "UserShopModel{" +
                "userModel=" + userModel +
                ", shopModel=" + shopModel +
                ", userRole=" + userRole +
                '}'
    }

    init {
        userModel = UserModel()
        shopModel = ShopModel()
    }
}