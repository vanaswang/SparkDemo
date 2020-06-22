package com.vanas.bigdata.test2

class Task extends Serializable {

    var data : Int = 0
    var logic : Int => Int  = null

    def compute() = {
    logic(data)
}
}
