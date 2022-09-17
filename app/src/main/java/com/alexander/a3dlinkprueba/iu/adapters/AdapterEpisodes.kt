package com.alexander.a3dlinkprueba.iu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexander.a3dlinkprueba.databinding.CardEpisodeBinding

class AdapterEpisodes(val episodes: List<String>): RecyclerView.Adapter<AdapterEpisodes.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CardEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun getItemCount()= episodes.size


    class MyViewHolder (val binding: CardEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cap: String) {

            binding.cardEpisode.text = cap



            }

    }
}
