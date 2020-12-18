package com.raag.recyclerviewonclickitem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.raag.recyclerviewonclickitem.R
import com.raag.recyclerviewonclickitem.adapter.MainAdapter
import com.raag.recyclerviewonclickitem.databinding.ActivityMainBinding
import com.raag.recyclerviewonclickitem.model.MainViewModel

class MainActivity : AppCompatActivity(), MainAdapter.ClicItem {

    private val adapter = MainAdapter(this)
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            //inicia el adaptador con el recyclervieew
            recyclerView.adapter = adapter

            //Observa los datos y los asigna por el adapter a la lista mutable
            viewModel.fetchData().observeForever { names ->
                adapter.setListData(names)
                adapter.notifyDataSetChanged()
            }
        }

    }

    //sobreescribe la función onClik para realizar la accion deseada
    override fun onClicListener(name: String, lastName: String) {
        val dialogName = AlertDialog.Builder(this)
        dialogName.setTitle("Person")
        dialogName.setMessage("El nombre de la personal es $name y su apellido es $lastName")
        dialogName.setIcon(R.mipmap.ic_launcher)
        val dialog = dialogName.create()
        dialog.show()
    }
}


