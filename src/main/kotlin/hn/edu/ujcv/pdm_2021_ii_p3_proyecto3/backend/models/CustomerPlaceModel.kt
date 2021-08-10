package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class CustomerPlaceModel {
    var customerModel: CustomerModel? = null
    var placeModel: PlaceModel? = null
    override fun toString(): String {
        return "CustomerPlaceModel{" +
                "customerModel=" + customerModel +
                ", placeModel=" + placeModel +
                '}'
    }
}
