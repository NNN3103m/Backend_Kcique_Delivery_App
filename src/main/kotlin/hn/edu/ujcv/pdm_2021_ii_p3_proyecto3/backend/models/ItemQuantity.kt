package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class ItemQuantity {
    @Column(name = "itemId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Porfavor ingresar el id")
    var itemId: String? = null

    @Column(name = "itemQuantity", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(6)
    @field:NotBlank(message = "Inserte una cantidad")
    var quantity: String? = null
}