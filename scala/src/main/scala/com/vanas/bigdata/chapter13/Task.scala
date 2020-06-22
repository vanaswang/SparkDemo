package com.vanas.bigdata.chapter13

/**
 * @author Vanas
 * @create 2020-06-01 2:11 下午 
 */
class Task extends Serializable {

    var data: Int = 0
    var logic: Int => Int = null

    def compute() = {
        logic(data)
    }

}