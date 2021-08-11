package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class UserModel {

    @Column(name = "userId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank
    @field:Id
    var id: Int? = null

    @Column(name = "userMobile", insertable = true, nullable = false )
    @field:Min(9)
    @field:Max(17)
    @field:NotBlank
    var mobile: String? = null

    @Column(name = "userName", insertable = true, nullable = false )
    @field:Min(10)
    @field:Max(65)
    @field:NotBlank
    var name: String? = null

    @Column(name = "", insertable = true, nullable = false )
    @field:Min(7)
    @field:Max(65)
    @field:NotBlank
    @field:Email
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