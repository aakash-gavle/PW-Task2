package com.example.pw_task2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pw_task2.model.DataModel

class MyViewModel:ViewModel() {

    private val mutableLiveData = MutableLiveData<ArrayList<DataModel>>()
    private var arrayList = ArrayList<DataModel>()
    fun addDataToList(name: String) {
        val model = DataModel(name, false)
        arrayList.add(model)
        mutableLiveData.postValue(arrayList)

    }

    fun getDataList(): MutableLiveData<ArrayList<DataModel>> {
        return mutableLiveData
    }

    fun getList(): ArrayList<DataModel> {
        return arrayList
    }

    fun removeItem(dataModel: DataModel) {
        arrayList.remove(dataModel)
        mutableLiveData.postValue(arrayList)
    }
}