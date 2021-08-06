package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import java.util.ArrayList

class UserShopListModel {
    var userModel: UserModel
    var shopModelList: List<ShopConfigurationModel>
    override fun toString(): String {
        return "UserShopListModel{" +
                "userModel=" + userModel +
                ", shopModelList=" + shopModelList +
                '}'
    }

    init {
        userModel = UserModel()
        shopModelList = ArrayList()
    }
}