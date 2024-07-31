package com.example.bancodigital.presenter.auth.recover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bancodigital.databinding.FragmentRecoverBinding

class RecoverFragment : Fragment() {

    private var _binding: FragmentRecoverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnEnviar.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.editEmailRecuperar.text.toString().trim()

        if (email.isNotEmpty()) {
            Toast.makeText(requireContext(), "E-mail enviado com sucesso", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(requireContext(), "Preencha o e-mail", Toast.LENGTH_SHORT).show()
        }
    }
}