package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank


class SellerModel {

    @Column(name = "sellerId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id")
    @field:Id
    var sellerId: Int? = null

    @Column(name = "sellerShopId", insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id del vendedor")
    @field:Id
    var sellerShopId: Int? = null

    override fun toString(): String {
        return "SellerModel{" +
                "sellerId=" + sellerId +
                ", sellerShopId='" + sellerShopId + '\'' +
                '}'
    }
}