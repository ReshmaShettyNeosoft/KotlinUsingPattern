package com.droidipc.kotlinusingpattern.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.util.Log
import com.droidipc.kotlinusingpattern.BR
import com.droidipc.kotlinusingpattern.R

class HomeViewModel : BaseObservable {
    var title: String = "Fruits"
    var fruitName: String? = null
    var mutableLiveData = MutableLiveData<ArrayList<FruitsDto>>()
    var arrayList: ArrayList<FruitsDto>? = null
    var fruitAdapter: FruitAdapter? = null
    var baseViewModel: BaseViewModel? = null
    @Bindable
    open var toastMessage: String = ""

    fun initialization() {
        arrayList = getFruitArrayList()
        fruitAdapter = FruitAdapter(R.layout.row_recyclerview, this, arrayList)
        baseViewModel = BaseViewModel()
    }

    constructor() : super()
    constructor(fruitName: String?) : super() {
        this.fruitName = fruitName
    }

    fun getAdapter(): FruitAdapter? {
        return fruitAdapter
    }

    //Get list of Fruits
    fun getFruitList(): MutableLiveData<ArrayList<FruitsDto>> {
        for (i in 1..5) {
            var fruitDto = FruitsDto("Fruit")
            arrayList?.add(fruitDto)
        }
        mutableLiveData.value = arrayList
        return mutableLiveData
    }


    fun getFruitByPosition(position: Int): FruitsDto? {
        return arrayList?.get(position)
    }


    //Get list of Fruits
    fun getFruitArrayList(): ArrayList<FruitsDto>? {
        var arrayListdata: ArrayList<FruitsDto>? = ArrayList()
        for (i in 1..5) {
            var fruitDto = FruitsDto("Fruit$i")
            arrayListdata?.add(fruitDto)
        }
        return arrayListdata
    }

    fun onRowClick(position: Int) {
        toastMessage = "Selected fruit :- ${arrayList!!.get(position).fruitName}"
        notifyPropertyChanged(BR.toastMessage)
    }
}