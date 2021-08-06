package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class ShopConfigurationModel {
    var shopModel: ShopModel? = null
    var ratingModel: RatingModel? = null
    var configurationModel: ConfigurationModel? = null
    override fun toString(): String {
        return "ShopConfigurationModel{" +
                "shopModel=" + shopModel +
                ", ratingModel=" + ratingModel +
                ", configurationModel=" + configurationModel +
                '}'
    }
}