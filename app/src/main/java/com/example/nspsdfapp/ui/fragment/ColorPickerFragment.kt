package com.example.nspsdfapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nspsdfapp.databinding.FragmentColorPickerBinding

class ColorPickerFragment : Fragment() {
    lateinit var binding: FragmentColorPickerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentColorPickerBinding.inflate(layoutInflater)
        return binding.root
    }

}