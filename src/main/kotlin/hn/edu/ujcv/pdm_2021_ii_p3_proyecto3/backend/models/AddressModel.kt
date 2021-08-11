package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models


class AddressModel {
    var addressId: Int? = null
    var country: String? = null
    var state: String? = null
    var postalCode: String? = null
    var streetName: String? = null
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