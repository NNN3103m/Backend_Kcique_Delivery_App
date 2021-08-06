package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class RatingModel {
    var shopModel: ShopModel
    var rating: Double? = null
    var userCount: Int? = null
    override fun toString(): String {
        return "RatingModel{" +
                "shopModel=" + shopModel +
                ", rating=" + rating +
                ", userCount=" + userCount +
                '}'
    }

    init {
        shopModel = ShopModel()
    }
}