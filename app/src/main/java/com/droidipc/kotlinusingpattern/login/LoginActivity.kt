package com.droidipc.kotlinusingpattern.login

import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.Toast
import com.droidipc.kotlinusingpattern.R
import com.droidipc.kotlinusingpattern.databinding.ActivityLoginBinding
import com.droidipc.kotlinusingpattern.home.HomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLoginBinding: ActivityLoginBinding= DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.loginViewModel = LoginViewModel()
        activityLoginBinding.executePendingBindings()

    }
}
@BindingAdapter("toastmsg")
fun display(view: View, msg: String?) {
    if (msg != null)
        Toast.makeText(view.context, msg, Toast.LENGTH_SHORT).show()
    //check login success
   if(msg.equals(view.context.getString(R.string.login_successful_txt)))
       view.context.startActivity(Intent(view.context, HomeActivity::class.java))
}

