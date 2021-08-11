package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class CustomerModel {

    @Column(name = "customerId", unique = true, insertable = true, nullable = false )
    @field:Min(1)
    @field:Max(15)
    @field:NotBlank(message = "Por favor ingresar un id")
    var id: Int? = null

    @Column(name = "mobileNumber", unique = true, insertable = true, nullable = false )
    @field:Min(9)
    @field:Max(17)
    @field:NotBlank(message = "Por favor ingresar un numero de telefono")
    var mobile: String? = null

    @Column(name = "customerName", insertable = true, nullable = false )
    @field:Min(2)
    @field:Max(56)
    @field:NotBlank(message = "Por favor ingresar un nombre")
    var name: String? = null

    @Column(name = "customerEmail", unique = true, insertable = true, nullable = false )
    @field:Min(8)
    @field:Max(60)
    @field:NotBlank(message = "Por favor ingresar un correo valido")
    @field:Email
    var email: String? = null

    @Column(name = "customerCreditCard", unique = true, insertable = true, nullable = false )
    @field:Min(14)
    @field:Max(16)
    @field:NotBlank(message = "Por favor ingrese una tarjeta de Credito/Debito")
    var creditcardId: Int? = null




    var role: Enums.UserRole? = null
    var oauthId: String? = null
    var notificationToken: List<String>? = null
    override fun toString(): String {
        return "CustomerModel{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", oauthId='" + oauthId + '\'' +
                ", notificationToken=" + notificationToken +
                ", role=" + role +
                ", creditcardid=" + creditcardId +
                '}'
    }
}