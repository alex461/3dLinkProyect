package com.alexander.a3dlinkprueba.iu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexander.a3dlinkprueba.databinding.ActivityDetailsBinding
import com.alexander.a3dlinkprueba.iu.adapters.AdapterEpisodes
import com.alexander.a3dlinkprueba.models.ModelCharacter
import com.alexander.a3dlinkprueba.utlis.showHide
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data= intent.getParcelableExtra<ModelCharacter>("pj")

        with(binding){

            Glide.with(characterImage.context)
                .load(data?.image)
                .fitCenter()
                .into(characterImage)


            characterName.text = data?.name
            characterStatusLabel.text = data?.status
            characterSpeciesLabel.text = data?.species
            characterGenderLabel.text = data?.gender
            characterOrigin.text = data?.origin?.name
            characterLocation.text = data?.location?.name

            rvEpisodeList.apply {
                layoutManager = LinearLayoutManager(this@DetailsActivity, LinearLayoutManager.VERTICAL, false)
                adapter = data?.let { AdapterEpisodes(it.episode) }
                episodeProgressBar.showHide()
            }


        }



    }
}