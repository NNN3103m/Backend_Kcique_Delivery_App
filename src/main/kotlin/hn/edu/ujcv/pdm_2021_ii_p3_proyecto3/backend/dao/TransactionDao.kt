package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.dao

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.Response
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.TransactionModel

interface TransactionDao {
    fun insertTransactionDetails(transactionModel: TransactionModel?): Response<String?>?
    fun updatePendingTransaction(transactionModel: TransactionModel?)
}