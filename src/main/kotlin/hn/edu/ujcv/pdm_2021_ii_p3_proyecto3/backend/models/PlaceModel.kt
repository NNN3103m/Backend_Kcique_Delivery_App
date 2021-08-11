package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class PlaceModel {

    @Column(name = "placeId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id")
    @field:Id
    var id: Int? = null

    @Column(name = "placeName", insertable = true, nullable = false )
    @field:Min(15)
    @field:Max(65)
    @field:NotBlank(message = "Por favor ingresar el nombre del local")
    var name: String? = null

    @Column(name = "placeAddress", insertable = true, nullable = false )
    @field:Min(15)
    @field:Max(65)
    @field:NotBlank(message = "Por favor ingresar la direccion del local")
    var address: String? = null

    var iconUrl: String? = null
    override fun toString(): String {
        return "PlaceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", address='" + address + '\'' +
                '}'
    }
}