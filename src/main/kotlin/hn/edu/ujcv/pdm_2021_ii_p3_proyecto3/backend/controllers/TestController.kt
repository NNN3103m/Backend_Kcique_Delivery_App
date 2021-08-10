package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants.ApiConfig.EMPTY_QUOTES
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class TestController {
    @GetMapping(value = [EMPTY_QUOTES])
    fun checkSetup(): String {
        var response = "<h1>Welcome to <span style=\"color:#ff4141;\">Zinger</span> Framework!!!</h1> "
        response += "<h2>All set</h2><br/><br/>"
        response += "<h3><a style=\"color:#ff4141;\" href=\"https://github.com/ddlogesh/zinger-framework/blob/master/Zinger%20framework%20(Release).json\">Postman API Collection</a></h3>"
        response += "<h3><a style=\"color:#ff4141;\" href=\"https://documenter.getpostman.com/view/6369926/Szmb6KVo?version=latest\">API Documentation</a></h3>"
        return response
    }
}