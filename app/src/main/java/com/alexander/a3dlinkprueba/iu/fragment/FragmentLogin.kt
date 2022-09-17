package com.alexander.a3dlinkprueba.iu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexander.a3dlinkprueba.databinding.FragmentLoginBinding
import com.alexander.a3dlinkprueba.iu.view.HomeActivity
import com.alexander.a3dlinkprueba.utlis.BaseFragment
import com.alexander.a3dlinkprueba.utlis.showToast
import com.alexander.a3dlinkprueba.viewModels.MyViewModel
import com.alexander.a3dlinkprueba.utlis.startNewActivity
import com.google.firebase.auth.FirebaseAuth


class FragmentLogin : BaseFragment<MyViewModel,FragmentLoginBinding>() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(binding){

            btLogin.setOnClickListener {

                if (etLogin.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()){

    

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(etLogin.text.toString(),etPassword.text.toString())
                        .addOnCompleteListener {

                            if (it.isSuccessful){

                                requireActivity().startNewActivity(HomeActivity::class.java)

                            }else{

                                requireActivity().showToast("ocurrio un Error")
                            }
                        }

                }



            }

            btRegister.setOnClickListener {

                if (etLogin.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()){

                FirebaseAuth.getInstance().
                createUserWithEmailAndPassword(
                    etLogin.text.toString(),
                    etPassword.text.toString())
                    .addOnCompleteListener {

                        if (it.isSuccessful){

                            requireActivity().showToast("cuenta creada con exito")

                        }else{

                            requireActivity().showToast("ocurrio un Error")
                        }
                    }

                }

            }

        }






    }



    override fun getViewModel() = MyViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container,false)

}