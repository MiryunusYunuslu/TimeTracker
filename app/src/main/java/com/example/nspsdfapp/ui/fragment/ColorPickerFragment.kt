package com.example.nspsdfapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nspsdfapp.databinding.FragmentColorPickerBinding
import com.example.nspsdfapp.utils.Constants.SELECTED_COLOR_FROM_PICKER
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener


class ColorPickerFragment : Fragment() {
    lateinit var binding: FragmentColorPickerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentColorPickerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setColorPickerView()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        btnSelect.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setColorPickerView() = with(binding) {
        colorPickerView.attachBrightnessSlider(alphaSlideBar)
        colorPickerView.setColorListener(ColorEnvelopeListener { color, fromUser ->
            tvColorHashcode.apply {
                setText("#" + color.hexCode.toString())
                setTextColor(color.color)
            }
            SELECTED_COLOR_FROM_PICKER = "#" + color.hexCode

        })
    }

}