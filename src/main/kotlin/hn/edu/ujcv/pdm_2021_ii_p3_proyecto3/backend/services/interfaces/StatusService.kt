package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.StatusModel

interface StatusService {
    fun insertStatusId(status: StatusModel?): Response<String?>?
    fun getStatus(statusId: StatusModel?): Response<String?>?
    fun updateStatus(statusId: StatusModel?): Response<String?>?
    fun deleteStatus(statusId: StatusModel?): Response<String?>?
}