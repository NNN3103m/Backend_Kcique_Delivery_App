package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.StatusModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.StatusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class StatusController {
    @Autowired
    var statusService: StatusService? = null

    @PostMapping("/post/{statusId}")
    fun insertStatus(@Valid @RequestBody statusModel: StatusModel?): Response<String?>? {
        return statusService!!.insertStatusId(statusModel)
    }
    @GetMapping("/get/{sellerId}")
    fun getStatus(@RequestBody statusModel: StatusModel?): Response<String?>? {
        return statusService!!.getStatus(statusModel)
    }

    @PutMapping()
    fun updateStatus(@RequestBody statusModel: StatusModel?): Response<String?>? {
        return statusService!!.updateStatus(statusModel)
    }

    @DeleteMapping()
    fun deleteStatus(@RequestBody statusModel: StatusModel?): Response<String?>? {
        return statusService!!.deleteStatus(statusModel)
    }
}