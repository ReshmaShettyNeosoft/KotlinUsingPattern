package com.droidipc.kotlinusingpattern

import android.content.Context

class ResourceProvider(context: Context){
var context:Context
    init {
    this.context =context
}
    fun getString(resId: Int): String {
        var cont: Context = this.context
        return cont.getString(resId)
    }

}