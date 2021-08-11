package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

class TransactionController {
    @Autowired
    var transactionService: TransactionService? = null

    @PostMapping("/post/{transactionId}")
    fun insertTransaction(@Valid @RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.insertTransaction(transactionModel)
    }
    @GetMapping("/get/{transactionId}")
    fun getSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.getTransactionId(transactionModel)
    }

    @PutMapping("/put/{transactionId}")
    fun updateSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.updateTransaction(transactionModel)
    }

    @DeleteMapping("/delete/{transactionId}")
    fun deleteSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.deleteTransaction(transactionModel)
    }
}