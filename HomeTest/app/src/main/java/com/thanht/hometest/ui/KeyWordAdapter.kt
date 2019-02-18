package com.thanht.hometest.ui

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.thanht.hometest.models.KeyWordModel
import com.thanht.hometest.R
import com.thanht.hometest.utils.formatLine
import kotlinx.android.synthetic.main.item_keyword.view.*

class KeyWordAdapter(private val keywordList: List<KeyWordModel>, val context: Context) :
    RecyclerView.Adapter<KeyWordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyWordViewHolder {
        return KeyWordViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_keyword,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return keywordList.size
    }

    override fun onBindViewHolder(holder: KeyWordViewHolder, position: Int) {
        val keyword = keywordList[position]
        holder.tvKeyword.text = formatLine(keyword.value)
        holder.cvItemKeyWord.setCardBackgroundColor(keyword.color)
    }

}

class KeyWordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvKeyword : TextView = itemView.tvName
    val cvItemKeyWord: CardView = itemView.cvItemKeyWord
}