package com.example.pw_task2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {

    val word= MutableLiveData<String>()

    fun addDataToList(name:String) {
        word.value=name
    }

    fun deleteItems(){

    }
}