package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class ItemModel {
    var id: Int? = null
    var name: String? = null
    var price: Double? = null
    var photoUrl: String? = null
    var category: String? = null
    var shopModel: ShopModel
    var isVeg: Int? = null
    var isAvailable: Int? = null
    override fun toString(): String {
        return "ItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", photoUrl='" + photoUrl + '\'' +
                ", category='" + category + '\'' +
                ", shopModel=" + shopModel +
                ", isVeg=" + isVeg +
                ", isAvailable=" + isAvailable +
                '}'
    }

    init {
        shopModel = ShopModel()
    }
}