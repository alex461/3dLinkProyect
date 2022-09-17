package com.alexander.a3dlinkprueba.iu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexander.a3dlinkprueba.databinding.FragmentHomeBinding
import com.alexander.a3dlinkprueba.iu.adapters.AdapterRickandMorti
import com.alexander.a3dlinkprueba.iu.view.DetailsActivity
import com.alexander.a3dlinkprueba.utlis.BaseFragment
import com.alexander.a3dlinkprueba.viewModels.MyViewModel
import kotlinx.coroutines.launch



class FragmentHome : BaseFragment<MyViewModel,FragmentHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            rvHome.layoutManager = GridLayoutManager(view.context, 2,LinearLayoutManager.VERTICAL, false)

            lifecycleScope.launch {

                viewModel.listCharacter()


                viewModel.characterList.collect{ character ->
                 rvHome.adapter = AdapterRickandMorti(character){

                     val intent = Intent(requireParentFragment().requireActivity(),DetailsActivity::class.java)
                     intent.putExtra("pj",it)
                     startActivity(intent)

                 }


                }







            }



        }



    }






    override fun getViewModel() = MyViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )=FragmentHomeBinding.inflate(inflater,container,false)

}