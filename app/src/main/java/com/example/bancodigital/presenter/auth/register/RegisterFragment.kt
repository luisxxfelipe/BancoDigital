package com.example.bancodigital.presenter.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bancodigital.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnCriarConta.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.campoEmail.text.toString().trim()
        val name = binding.campoNome.text.toString().trim()
        val phone = binding.campoCelular.text.toString().trim()
        val password = binding.campoSenha.text.toString().trim()

        if (email.isNotEmpty() && name.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()) {
            Toast.makeText(requireContext(), "Registro realizado com sucesso", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(
                requireContext(),
                "Preencha todos os campos corretamente.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}