package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Time
import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class ShopModel {

    @Column(name = "shopId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    @field:Id
    var id: Int? = null

    @Column(name = "shopName", insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(65)
    @field:NotBlank
    var name: String? = null


    @Column(name = "shopMobileNumber", insertable = true, nullable = false )
    @field:Min(9)
    @field:Max(17)
    @field:NotBlank
    var mobile: String? = null

    var placeModel: PlaceModel
    var photoUrl: String? = null
    var coverUrls: List<String>? = null

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