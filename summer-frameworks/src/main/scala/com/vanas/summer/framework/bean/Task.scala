package com.vanas.summer.framework.bean

/**
 * @author Vanas
 * @create 2020-05-23 9:54 上午 
 */
class Task extends Serializable {

    var data: Int = 0
    var logic: Int => Int = null

    def compute() = {
        logic(data)
    }

}
