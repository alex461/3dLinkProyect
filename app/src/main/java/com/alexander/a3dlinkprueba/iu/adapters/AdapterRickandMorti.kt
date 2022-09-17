package com.alexander.a3dlinkprueba.iu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexander.a3dlinkprueba.databinding.CardViewBinding
import com.alexander.a3dlinkprueba.models.ModelCharacter
import com.bumptech.glide.Glide

class AdapterRickandMorti (var characters: List<ModelCharacter>,
                           private val productClickedListener : (ModelCharacter)-> Unit) : RecyclerView.Adapter<AdapterRickandMorti.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false))
    }




    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener { productClickedListener(character) }

    }

    override fun getItemCount() = characters.size

    class MyViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(modelCharacter: ModelCharacter) {


            with(binding) {

                characterName.text = modelCharacter.name

                Glide.with(characterImage.context)
                    .load(modelCharacter.image)
                    .fitCenter()
                    .into(characterImage)



            }




        }
    }

}

