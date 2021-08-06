package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.exceptions

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import java.lang.RuntimeException

class GenericException(var response: Response<*>) : RuntimeException() {
    override fun toString(): String {
        return "GenericException{" +
                "response=" + response +
                '}'
    }
}