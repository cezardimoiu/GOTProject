package com.example.gotproject

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter (val context: Context, val charactersList: List<DataCharactersItem>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var alias: TextView

        init {
            name = itemView.findViewById(R.id.characterName)
            alias = itemView.findViewById(R.id.aliasName)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, p0, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        if (!isEmpty(charactersList[p1].name)) {
            p0.name.text = charactersList[p1].name
            if (isEmpty(charactersList[p1].aliases[0]))
                p0.alias.text = "no alias"
            else
                p0.alias.text = charactersList[p1].aliases[0]
        } else {
            p0.name.text = "Unknown"
            p0.alias.text = charactersList[p1].aliases[0]
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}