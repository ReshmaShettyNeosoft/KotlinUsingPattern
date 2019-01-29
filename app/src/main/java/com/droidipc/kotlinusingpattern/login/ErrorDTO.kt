package com.droidipc.kotlinusingpattern.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ErrorDTO (){
    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("data")
    @Expose
    var data: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("user_msg")
    @Expose
    var userMsg: String? = null
}