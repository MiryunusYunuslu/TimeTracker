package com.example.nspsdfapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nspsdfapp.R
import com.example.nspsdfapp.adapter.HomeMainProjectAdapter
import com.example.nspsdfapp.adapter.HomeRunningProjectsAdapter
import com.example.nspsdfapp.databinding.FragmentHomeBinding
import com.example.nspsdfapp.utils.Data

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdapter: HomeMainProjectAdapter
    lateinit var homeRunningProjectsAdapter: HomeRunningProjectsAdapter

    var runningProjectShowing = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        setTopProjectsRecyclerView()
        setRunningProjectsRecyclerView()
        setClickListeners()
        homeAdapter.setItems(Data.getProjects())
    }

    private fun initAdapters() {
        homeAdapter = HomeMainProjectAdapter()
        homeRunningProjectsAdapter = HomeRunningProjectsAdapter()
    }

    private fun setTopProjectsRecyclerView() = with(binding) {
        rvTopProjects.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }
    }

    private fun setRunningProjectsRecyclerView() = with(binding) {
        rvRunningProjects.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeRunningProjectsAdapter
        }
    }

    private fun setClickListeners() = with(binding) {
        ivDropDown.setOnClickListener {
            if (!runningProjectShowing) {
                binding.ivDropDown.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                rvRunningProjects.visibility = View.VISIBLE
                homeRunningProjectsAdapter.setItems(Data.getProjects())
                rvRunningProjects.scheduleLayoutAnimation()
                runningProjectShowing = true

            } else {
                binding.ivDropDown.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                homeRunningProjectsAdapter.clearItems()
                runningProjectShowing = false
                homeAdapter.setItems(Data.getProjects())
            }

        }
        tvAddProject.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }


    }
}