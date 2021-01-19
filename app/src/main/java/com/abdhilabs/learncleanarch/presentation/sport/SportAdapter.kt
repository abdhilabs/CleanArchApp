package com.abdhilabs.learncleanarch.presentation.sport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.domain.sport.model.Sport
import com.abdhilabs.learncleanarch.databinding.ItemSportBinding

class SportAdapter : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    private val sports = mutableListOf<Sport>()

    fun refreshItems(items: List<Sport>) {
        this.sports.clear()
        this.sports.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemSportBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sport) {
            binding.sport = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSportBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sports[position])
    }

    override fun getItemCount(): Int = sports.size
}