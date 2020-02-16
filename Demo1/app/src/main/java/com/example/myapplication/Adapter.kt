package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter internal constructor(
    context: Context
) : RecyclerView.Adapter<Adapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var models = emptyList<Model>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Username: TextView = itemView.findViewById(R.id.username)
        val Password: TextView = itemView.findViewById(R.id.password)
        val Emai: TextView = itemView.findViewById(R.id.email)
        val Address: TextView = itemView.findViewById(R.id.address)
        val Gioitinh: TextView = itemView.findViewById(R.id.gioitinh)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = models[position]
        holder.Username.text = current.Username
        holder.Password.text = current.Password
        holder.Emai.text = current.Email
        holder.Address.text = current.Address
        holder.Gioitinh.text = current.Giơitinh

    }

    internal fun setWords(models: List<Model>) {
        this.models=models
        notifyDataSetChanged()
    }

    override fun getItemCount() = models.size
}