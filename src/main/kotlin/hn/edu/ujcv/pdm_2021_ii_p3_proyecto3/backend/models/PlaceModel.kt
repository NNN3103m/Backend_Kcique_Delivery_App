package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class PlaceModel {
    var id: Int? = null
    var name: String? = null
    var iconUrl: String? = null
    var address: String? = null
    override fun toString(): String {
        return "PlaceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", address='" + address + '\'' +
                '}'
    }
}