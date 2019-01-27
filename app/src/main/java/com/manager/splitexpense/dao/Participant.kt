package com.manager.splitexpense.dao

import java.io.Serializable

class Participant : Serializable {


    var name: String? = null
    var number: String? = null

    var paidAmount: Int? = null
    var owedAmount: Int? = null
    var paidOwedDiff: Int? = null
}
