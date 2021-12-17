package com.example.mysampleapplication

data class Dish_Data(
    val id: Int=0,
    val url:String="",
    val name: String="",
    val price: Int=0,
    val contents: String="",
    val type: String=""
)

data class AllDishes(
    val dishes:List<Dish_Data>?=null
)