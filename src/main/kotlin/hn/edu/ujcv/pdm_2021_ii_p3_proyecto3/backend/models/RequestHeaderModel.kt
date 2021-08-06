package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

class RequestHeaderModel {
    var oauthId: String? = null
    var id: Int? = null
    var role: String? = null

    constructor() {}
    constructor(oauthId: String?, id: Int?, role: String?) {
        this.oauthId = oauthId
        this.id = id
        this.role = role
    }

    override fun toString(): String {
        return "RequestHeaderModel{" +
                "oauthId='" + oauthId + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                '}'
    }
}