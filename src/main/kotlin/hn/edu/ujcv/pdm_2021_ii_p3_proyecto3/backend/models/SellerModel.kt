package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models


class SellerModel {
    var sellerId: Int? = null
    var sellerShopId: Int? = null

    override fun toString(): String {
        return "SellerModel{" +
                "sellerId=" + sellerId +
                ", sellerShopId='" + sellerShopId + '\'' +
                '}'
    }
}