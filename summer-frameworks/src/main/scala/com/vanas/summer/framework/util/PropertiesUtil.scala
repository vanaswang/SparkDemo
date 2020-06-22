package com.vanas.summer.framework.util

import java.util.ResourceBundle

/**
 * @author Vanas
 * @create 2020-05-23 9:31 上午 
 */
object PropertiesUtil {

    //绑定配置文件
    //ResourceBundle：专门用于读取配置文件，所以读取时，不需要增加扩展名
    //国际化：I18N
    val summer: ResourceBundle = ResourceBundle.getBundle("summer")

    def getValue(key: String): String = {
        summer.getString(key)

    }

}
