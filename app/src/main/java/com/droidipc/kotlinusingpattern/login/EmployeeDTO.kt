package com.droidipc.kotlinusingpattern.login

import android.util.Log
import com.droidipc.kotlinusingpattern.service.APIClient
import com.droidipc.kotlinusingpattern.service.RetrofitAPIinterface
import retrofit2.Callback


data class EmployeeDTO(var userName: String = "demo007@gmail.com", var password: String = " Kannan123"){
}
