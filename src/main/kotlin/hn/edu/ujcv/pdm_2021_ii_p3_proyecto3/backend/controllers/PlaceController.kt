package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.PlaceApi.BASE_URL
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.PlaceModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.PlaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(BASE_URL)
class PlaceController {
    @Autowired
    var placeService: PlaceService? = null
    @PostMapping(value = [insertPlace])
    fun insertPlace(@RequestBody placeModel: PlaceModel?): Response<String> {
        return placeService!!.insertPlace(placeModel)
    }

    @get:GetMapping(value = [getAllPlaces])
    val allPlaces: Response<List<PlaceModel>>
        get() = placeService!!.allPlaces

    @GetMapping(value = [getAllPlaces])
    fun getAllPlaces(): Response<List<PlaceModel>> {
        return placeService!!.allPlaces
    }
}