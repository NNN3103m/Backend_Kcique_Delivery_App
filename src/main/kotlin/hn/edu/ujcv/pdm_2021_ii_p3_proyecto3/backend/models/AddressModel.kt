package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank


class AddressModel {

    @Column(name = "addressId", unique = true, insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id")
    @field:Id
    var addressId: Int? = null

    @Column(name = "country", insertable = true, nullable = false )
    @field:Min(4)
    @field:Max(56)
    @field:NotBlank(message = "Por favor ingresar el pais")
    var country: String? = null

    @Column(name = "state", insertable = true, nullable = false )
    @field:Min(5)
    @field:Max(35)
    @field:NotBlank(message = "Por favor ingresar el departamento")
    var state: String? = null

    @Column(name = "postalCode", unique = true, insertable = true, nullable = false )
    @field:Min(3)
    @field:Max(6)
    @field:NotBlank(message = "Por favor ingresar el codigo postal")
    var postalCode: String? = null

    @Column(name = "streetName", insertable = true, nullable = false )
    @field:Min(6)
    @field:Max(35)
    @field:NotBlank(message = "Por favor ingresar el nombre de la calle")
    var streetName: String? = null

    @Column(name = "streetNumber", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(5)
    @field:NotBlank(message = "Por favor ingresar el numero de calle o casa")
    var streetNumber: List<String>? = null
    
    override fun toString(): String {
        return "AddressModel{" +
                "streetId=" + addressId +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                '}'
    }
}