package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class SellerLoginResponse {
    var userModel: UserModel? = null
    var shopModel: ShopModel? = null
    var configurationModel: ConfigurationModel? = null
    var ratingModel: RatingModel? = null
    override fun toString(): String {
        return "SellerLoginResponse{" +
                "userModel=" + userModel +
                ", shopModel=" + shopModel +
                ", configurationModel=" + configurationModel +
                ", ratingModel=" + ratingModel +
                '}'
    }
}