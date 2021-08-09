package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.exceptions

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response

class GenericException(response: Response<*>) : RuntimeException() {
    private var response: Response<*>
    fun getResponse(): Response<*> {
        return response
    }

    fun setResponse(response: Response<*>) {
        this.response = response
    }

    override fun toString(): String {
        return "GenericException{" +
                "response=" + response +
                '}'
    }

    init {
        this.response = response
    }
}