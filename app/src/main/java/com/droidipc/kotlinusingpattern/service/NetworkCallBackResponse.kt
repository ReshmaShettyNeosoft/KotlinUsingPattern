package com.droidipc.kotlinusingpattern.service

import android.util.Log
import com.droidipc.kotlinusingpattern.login.LoginViewModel
import retrofit2.Call
import retrofit2.Callback


abstract class NetworkCallBackResponse<T>(var statusInterface: StatusInterface<T?>): Callback<T> {
    override
     fun onFailure(call: Call<T>, t: Throwable) {
        statusInterface.requestStatus(false,null,"")
        Log.d("Testing","Testing Error :-"+t.message)
    }

}