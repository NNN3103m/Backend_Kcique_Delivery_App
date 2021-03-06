package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class ItemModel {

//    Validations

//    @field:NotBlank
//    @field:Min(1)
//    @field:Max(150)
//    val id = Int
//    val name = String
//    val price = Double


    @Column(name = "itemId", unique = true, insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar el id")
    @field:Id
    var id: Int? = null

    @Column(name = "itemName", insertable = true, nullable = false )
    @field:Min(2)
    @field:Max(30)
    @field:NotBlank(message = "Por favor ingresar el nombre del item")
    var name: String? = null

    @Column(name = "itemPrice", insertable = true, nullable = true )
    @field:Min(1)
    @field:Max(8)
    @field:NotBlank(message = "Por favor ingresar el precio del item")
    var price: Double? = null

    var photoUrl: String? = null

    @Column(name = "itemCategory", insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar la categoria del item")
    var category: String? = null

    var shopModel: ShopModel
    var isAvailable: Int? = null
    override fun toString(): String {
        return "ItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", photoUrl='" + photoUrl + '\'' +
                ", category='" + category + '\'' +
                ", shopModel=" + shopModel +
                ", isAvailable=" + isAvailable +
                '}'
    }

    init {
        shopModel = ShopModel()
    }
}