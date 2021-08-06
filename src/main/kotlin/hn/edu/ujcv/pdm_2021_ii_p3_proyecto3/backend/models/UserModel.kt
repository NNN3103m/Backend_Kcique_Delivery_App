package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums

class UserModel {
    var id: Int? = null
    var mobile: String? = null
    var name: String? = null
    var email: String? = null
    var oauthId: String? = null
    var notificationToken: List<String>? = null
    var role: Enums.UserRole? = null
    override fun toString(): String {
        return "UserModel{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", oauthId='" + oauthId + '\'' +
                ", notificationToken=" + notificationToken +
                ", role=" + role +
                '}'
    }
}