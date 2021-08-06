package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class UserPlaceModel {
    var userModel: UserModel? = null
    var placeModel: PlaceModel? = null
    override fun toString(): String {
        return "UserPlaceModel{" +
                "userModel=" + userModel +
                ", placeModel=" + placeModel +
                '}'
    }
}