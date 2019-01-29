package com.droidipc.kotlinusingpattern.login

import android.util.Log
import com.droidipc.kotlinusingpattern.commonUtils.ConstantHandler
import com.droidipc.kotlinusingpattern.service.APIClient
import com.droidipc.kotlinusingpattern.service.NetworkCallBackResponse
import com.droidipc.kotlinusingpattern.service.RetrofitAPIinterface
import com.droidipc.kotlinusingpattern.service.StatusInterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import org.json.JSONObject




class LoginModel {

    //object iniliazation.
    val constantHandler: ConstantHandler = ConstantHandler()
    val apiClient: APIClient = APIClient()

    var apiInterface: RetrofitAPIinterface =
        apiClient.getClient(constantHandler.BASE_URL)!!.create(RetrofitAPIinterface::class.java)

    open fun checkEmptyfields(employeeDTO: EmployeeDTO): Boolean {
        return if (employeeDTO.userName == null || employeeDTO.userName.isEmpty() || employeeDTO.password.isEmpty() || employeeDTO.password == null) false else true
    }

    //login API Call
    open fun postLoginRequest(employeeDTO: EmployeeDTO, statusInterface: StatusInterface<LoginResponseDTO?>) {
        var loginResponseDTO: LoginResponseDTO? = null
        val call = apiInterface.loginRequest(employeeDTO.userName, employeeDTO.password)

        call.enqueue(object : NetworkCallBackResponse<LoginResponseDTO>(statusInterface) {
            override fun onResponse(call: Call<LoginResponseDTO>, response: Response<LoginResponseDTO>) {
                loginResponseDTO = response.body() ?: null
                /*  if (response.body() != null) {
                    loginResponseDTO = response.body()
                }*/
                if (loginResponseDTO?.status == 200)
                statusInterface.requestStatus(true, loginResponseDTO, response.body().message!!)
                else {
                    var errorDTO: ErrorDTO = Gson().fromJson(JSONObject(response.errorBody().string()).toString(),ErrorDTO::class.java)
                    statusInterface.requestStatus(true, null, errorDTO.userMsg!!)
                }
            }
        })
    }

}