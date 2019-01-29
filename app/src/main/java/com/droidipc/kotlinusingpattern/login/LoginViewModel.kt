package com.droidipc.kotlinusingpattern.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableInt
import com.droidipc.kotlinusingpattern.BR
import com.droidipc.kotlinusingpattern.R

import com.droidipc.kotlinusingpattern.service.StatusInterface

class LoginViewModel (): BaseObservable(){

    @Bindable
    open var toastmsg: String = ""
    @Bindable
    var employeeDTO: EmployeeDTO = EmployeeDTO()
    var loginModel: LoginModel = LoginModel()
    val login = ObservableInt(R.string.login_txt)


    //login button click.
    fun OnLoginClick() {
        if (loginModel.checkEmptyfields(employeeDTO)) {
            //ApiCall
            loginModel.postLoginRequest(employeeDTO, object : StatusInterface<LoginResponseDTO?> {
                override fun requestStatus(isRequestSuccess: Boolean, responseObject: LoginResponseDTO?, responseStatus: String) {
                    if (isRequestSuccess) {
                        toastmsg = responseStatus
                    }
                    else toastmsg = "registration failed"

                    notifyPropertyChanged(BR.toastmsg)
                }
            })

        } else {
        toastmsg = "please Fill all detail"

          notifyPropertyChanged(BR.toastmsg)
        }
    }

    fun onChangeUsername(s: CharSequence) {
        employeeDTO.userName = s.toString();
        notifyPropertyChanged(BR.employeeDTO);
    }

    fun onChangePassword(s: CharSequence) {
        employeeDTO.password = s.toString();
    }
}


