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
import com.example.nspsdfapp.databinding.FragmentHistoryBinding
import com.example.nspsdfapp.utils.Data

class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding
    lateinit var mainAdapter: HomeMainProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = HomeMainProjectAdapter("history")
        initRecyclerview()
        setClickListeners()
        loadData()
    }

    private fun setClickListeners() = with(binding) {
        ibReturnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        tvAllStatistics.setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment_to_allStatisticsFragment)
        }
    }

    private fun loadData() {
        mainAdapter.setItems(Data.getProjects())
    }

    private fun initRecyclerview() = with(binding) {
        rvProjects.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainAdapter
        }

    }


}