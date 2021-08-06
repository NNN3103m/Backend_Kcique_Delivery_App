package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.RatingModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ShopModel

interface RatingDao {
    fun getRatingByShopId(shopModel: ShopModel?): Response<RatingModel?>?
    fun updateShopRating(shopId: Int?, rating: Double?)
}