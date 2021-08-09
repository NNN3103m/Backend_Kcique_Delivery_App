package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.constants

class Query {
    object AuditLogQuery {
        const val insertLog = Sql.INSERT_INTO + Column.ApplicationLogColumn.tableName + Sql.LEFT_PARANTHESIS
    }
}

