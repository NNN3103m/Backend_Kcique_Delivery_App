package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.Enums
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ErrorLog

class Response<T> {
    var code: Int
    var message: String
    private var priority: Enums.Priority
    var data: T? = null
        private set

    fun priorityGet(): Enums.Priority {
        return priority
    }

    fun prioritySet(priority: Enums.Priority) {
        this.priority = priority
    }

    fun setData(data: T) {
        this.data = data
    }

    override fun toString(): String {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }

    fun setMessage(itemDetailNotUpdated: T): String {
        return "item not updated"
    }

    fun setCode(idnU1207: Int): String {
        return "Error"
    }

    fun getCode(): Any {
        return "code here"
    }

    @JvmName("getData1")
    fun getData(): Any {
        return "data" + data
    }

    init {
        code = ErrorLog.CodeFailure
        message = ErrorLog.Failure
        priority = Enums.Priority.MEDIUM
    }
}