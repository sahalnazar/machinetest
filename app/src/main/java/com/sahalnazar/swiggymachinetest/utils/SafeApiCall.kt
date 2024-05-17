package com.sahalnazar.swiggymachinetest.utils

suspend inline fun <T> safeApiCall(responseFunction: suspend () -> T): T?{
    return try{
        responseFunction.invoke()
    }catch (e: Exception){
        e.printStackTrace()
        null
    }
}
