package com.nhathuy.cupcakes.data

data class OrderUiState(
    val quantity:Int=0,
    val model:String="",
    val type:String="",
    val color:String="",
    val date:String="",
    val price:String="",
    val pickupOptions:List<String> = listOf()
)
