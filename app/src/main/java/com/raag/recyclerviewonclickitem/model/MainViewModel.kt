package com.raag.recyclerviewonclickitem.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raag.recyclerviewonclickitem.data.Names
import com.raag.recyclerviewonclickitem.repo.Repo

class MainViewModel {
    private val repo = Repo()

    //asigna la lista de Firebase en la lista mutable local
    fun fetchData(): LiveData<MutableList<Names>> {
        val mutableData = MutableLiveData<MutableList<Names>>()
        repo.getData().observeForever { names ->
            mutableData.value = names
        }
        return mutableData
    }

}