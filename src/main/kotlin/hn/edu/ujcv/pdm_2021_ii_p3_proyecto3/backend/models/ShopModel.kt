package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Time

class ShopModel {
    var id: Int? = null
    var name: String? = null
    var photoUrl: String? = null
    var coverUrls: List<String>? = null
    var mobile: String? = null
    var placeModel: PlaceModel

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/Chicago")
    var openingTime: Time? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/Chicago")
    var closingTime: Time? = null
    override fun toString(): String {
        return "ShopModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", coverUrls=" + coverUrls +
                ", mobile='" + mobile + '\'' +
                ", placeModel=" + placeModel +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}'
    }

    init {
        placeModel = PlaceModel()
    }
}