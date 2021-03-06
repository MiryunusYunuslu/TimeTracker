package com.example.nspsdfapp.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nspsdfapp.R
import com.example.nspsdfapp.adapter.AddProjectColorsAdapter
import com.example.nspsdfapp.databinding.FragmentAddBinding
import com.example.nspsdfapp.model.ProjectModel
import com.example.nspsdfapp.utils.Constants
import com.example.nspsdfapp.utils.Constants.SELECTED_COLOR
import com.example.nspsdfapp.utils.Constants.SELECTED_COLOR_FROM_PICKER
import com.example.nspsdfapp.utils.Constants.SELECTED_PROJECT_NAME
import com.example.nspsdfapp.utils.Data


class AddFragment : Fragment(), AddFragmentView {
    lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        checkColorPicker()
        setUpRecyclerView()
        setUpClickListeners()
        return binding.root
    }

    private fun checkColorPicker() {
        if (SELECTED_COLOR_FROM_PICKER != "") {
            Constants.ADD_COLOR_LIST[0] = SELECTED_COLOR_FROM_PICKER
            binding.ivBackgroundProjectShape.setBackgroundColor(
                Color.parseColor(
                    SELECTED_COLOR_FROM_PICKER
                )
            )
        }
    }

    private fun setUpClickListeners() = with(binding) {
        btnAdd.setOnClickListener {
            if (teProjectName.text!!.isNotEmpty()) {
                SELECTED_PROJECT_NAME = teProjectName.text.toString()
                Data.addProject(
                    ProjectModel(
                        SELECTED_COLOR,
                        SELECTED_PROJECT_NAME,
                        Pair("00", "00"),
                        false
                    )
                )
                findNavController().navigateUp()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Project name can'not be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        ibArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        tvAddColor.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_colorPickerFragment)
        }

    }

    private fun setUpRecyclerView() = with(binding) {
        rvColors.layoutManager = GridLayoutManager(requireContext(), 4)
        val adapter = AddProjectColorsAdapter(Constants.ADD_COLOR_LIST, this@AddFragment)
        rvColors.adapter = adapter
    }

    override fun showColorOnProject(color: String) = with(binding) {
        ivBackgroundProjectShape.setBackgroundColor(Color.parseColor(color))
    }


}