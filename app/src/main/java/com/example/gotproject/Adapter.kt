package com.example.gotproject

import android.content.Context
import android.provider.ContactsContract
import androidx.recyclerview.widget.RecyclerView
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter (): RecyclerView.Adapter<Adapter.ViewHolder>() {
    var charactersList: List<DataCharactersItem>? = null
    fun setListData(listData: List<DataCharactersItem>?) {
        this.charactersList = listData
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var culture: TextView

        init {
            name = itemView.findViewById(R.id.characterName)
            culture = itemView.findViewById(R.id.aliasName)
        }

        fun bind(data: DataCharactersItem) {
            if (!isEmpty(data.name)) {
                name.text = data.name
                if (isEmpty(data.culture))
                    culture.text = "no culture"
                else
                    culture.text = data.culture
            } else {
                name.text = "Unknown"
                culture.text = data.culture
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {

        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bind(charactersList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (charactersList == null) return 0
        return charactersList?.size!!
    }
}