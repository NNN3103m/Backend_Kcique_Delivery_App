package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.services.interfaces

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionModel

interface TransactionService {
    fun insertTransaction(transactions: TransactionModel?): Response<String?>?
    fun getTransactionId(transactionsId: TransactionModel?): Response<String?>?
    fun updateTransaction(transactionsId: TransactionModel?): Response<String?>?
    fun deleteTransaction(transactionsId: TransactionModel?): Response<String?>?
}