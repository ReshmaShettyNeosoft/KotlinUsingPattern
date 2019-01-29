package com.droidipc.kotlinusingpattern.home

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.droidipc.kotlinusingpattern.R
import com.droidipc.kotlinusingpattern.databinding.ActivityHomeBinding
import com.droidipc.kotlinusingpattern.databinding.ActivityLoginBinding
import com.droidipc.kotlinusingpattern.login.LoginViewModel

class HomeActivity : AppCompatActivity() {
    var viewModel: HomeViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databindingSetup()
    }

    fun databindingSetup(){
        val activityHomeBinding: ActivityHomeBinding= DataBindingUtil.setContentView(this, R.layout.activity_home)
        activityHomeBinding.homeViewModel= HomeViewModel()
        activityHomeBinding.homeViewModel!!.initialization()
    }

}