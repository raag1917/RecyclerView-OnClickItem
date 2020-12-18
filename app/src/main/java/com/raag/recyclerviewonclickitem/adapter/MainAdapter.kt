package com.raag.recyclerviewonclickitem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raag.recyclerviewonclickitem.R
import com.raag.recyclerviewonclickitem.data.Names
import com.raag.recyclerviewonclickitem.databinding.RowBinding

class MainAdapter (private val onClickItem: ClicItem): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Names>()

    //permite asignar la lista de Firebase a la variable local
    fun setListData(data: MutableList<Names>) {
        dataList = data
    }
    //permite inicar la función que manejará el evento onClick
    interface ClicItem {
        fun onClicListener(name: String, lastName: String)
    }

    //permite inflar la vista del item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))

    //permite definir la posición de cada elemento dentro del recyclerview
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //define el tamaño de la vista
    override fun getItemCount() = dataList.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)

        fun bind(names: Names) = with(binding) {
            more.setOnClickListener { onClickItem.onClicListener(names.name, names.lastName) }
            tvName.text = names.name
            tvLastName.text = names.lastName

        }
    }
}