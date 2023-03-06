package com.rizki.cleanarch.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rizki.cleanarch.R
import com.rizki.cleanarch.databinding.FragmentLoginBinding
import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.utils.isNetworkAvailable
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater,container,false);
        return loginBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initComponent()
    }

    private fun initComponent() {

        loginViewModel.postsData.observe(viewLifecycleOwner){
                if (it.token.isNotEmpty()){
                    
                }

        }

        loginBinding.btnLogin.setOnClickListener {
            var email = loginBinding.etEmail.text.toString()
            var pass = loginBinding.etPass.text.toString()

            val loginRequest = LoginRequest(email, pass)
            doLogin(loginRequest)
        }
    }

    private fun doLogin(loginRequest: LoginRequest){
        if (context?.isNetworkAvailable() == true){
            loginViewModel.doLogin(loginRequest)
        } else {
            Toast.makeText(
                context,
                getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}