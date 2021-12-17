package com.example.mysampleapplication

data class LoginData(val id:Int,
                     val email:String,
                     val password:String,
                     val token:String,
                     val memberSince:Long )


data class UserData(val email: String,
                    val password: String) {

}
