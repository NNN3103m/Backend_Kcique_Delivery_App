package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.controllers

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionModel
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

class TransactionController {
    @Autowired
    var transactionService: TransactionService? = null

    @PostMapping()
    fun insertTransaction(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.insertTransaction(transactionModel)
    }
    @GetMapping()
    fun getSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.getTransactionId(transactionModel)
    }

    @PutMapping()
    fun updateSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.updateTransaction(transactionModel)
    }

    @DeleteMapping()
    fun deleteSeller(@RequestBody transactionModel: TransactionModel?): Response<String?>? {
        return transactionService!!.deleteTransaction(transactionModel)
    }
}