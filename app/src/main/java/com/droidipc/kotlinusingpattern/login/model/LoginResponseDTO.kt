package com.droidipc.kotlinusingpattern.login.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponseDTO (){
     @SerializedName("status")
     @Expose
     var status: Int? = null
     @SerializedName("data")
     @Expose
     var dataDTO: UserDataDTO? = null
     @SerializedName("message")
     @Expose
     var message: String? = null
     @SerializedName("user_msg")
     @Expose
     var userMsg: String? = null
 }

