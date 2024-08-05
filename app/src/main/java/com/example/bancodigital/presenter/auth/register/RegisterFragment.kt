package com.example.bancodigital.presenter.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bancodigital.data.model.User
import com.example.bancodigital.databinding.FragmentRegisterBinding
import com.example.bancodigital.util.StateView
import com.example.bancodigital.util.initToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val registerViewModel: RegisterViewModel by viewModels()

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
        initToolbar(binding.toolbar)
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

        if (name.isNotEmpty()) {
            if (email.isNotEmpty()) {
                if (phone.isNotEmpty()) {
                    if (password.isNotEmpty()) {

                        binding.progressBar.isVisible = true

                        val user = User(name, email, phone, password)
                        registerUser(User(name, email, phone, password))

                    } else {
                        Toast.makeText(requireContext(), "Preencha a senha!", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Preencha o celular!", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(requireContext(), "Preencha o e-mail!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), "Preencha o nome!", Toast.LENGTH_SHORT).show()
        }

        }

    private fun registerUser(user: User) {
        Toast.makeText(
            requireContext(),
            "Cadastrado com sucesso!",
            Toast.LENGTH_SHORT
        ).show()

        registerViewModel.register(user).observe(viewLifecycleOwner) { statview ->
            when (statview) {
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        statview.message, Toast.LENGTH_SHORT
                    ).show()

                }

                is StateView.Sucess -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}