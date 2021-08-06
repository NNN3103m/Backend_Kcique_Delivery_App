package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.PlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response

interface PlaceDao {
    fun insertPlace(placeModel: PlaceModel?): Response<String?>?
    val allPlaces: Response<List<PlaceModel?>?>?
}