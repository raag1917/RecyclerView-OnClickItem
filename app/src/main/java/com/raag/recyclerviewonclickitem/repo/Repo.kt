package com.raag.recyclerviewonclickitem.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.raag.recyclerviewonclickitem.data.Names

class Repo {
    //recuperación de los tados de la lista de Firebase
    fun getData(): LiveData<MutableList<Names>> {
        val mutableData = MutableLiveData<MutableList<Names>>()
        FirebaseFirestore.getInstance().collection("Nombres").get().addOnSuccessListener { names ->
            val listData = mutableListOf<Names>()
            for(document in names){
                val name = document.getString("name")
                val lastName = document.getString("lastName")
                val list = Names(name!!, lastName!!)
                listData.add(list)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}