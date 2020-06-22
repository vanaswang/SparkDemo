package com.vanas.bigdata.chapter01

import com.vanas.bigdata.chapter10.Scala06_Transform.User

object Scala06_ImplicitClass {

    implicit class UserExt(user: User) {
        def updataUser() = {
            println("updata user...")
        }
    }
}
