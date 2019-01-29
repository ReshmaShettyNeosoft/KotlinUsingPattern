package com.droidipc.kotlinusingpattern.service


interface StatusInterface<T> {
    fun requestStatus(isRequestSuccess : Boolean,responseObject : T,responseStatus: String)

}