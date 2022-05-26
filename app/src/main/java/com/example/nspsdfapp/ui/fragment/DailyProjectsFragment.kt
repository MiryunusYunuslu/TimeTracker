package com.example.nspsdfapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nspsdfapp.adapter.HomeMainProjectAdapter
import com.example.nspsdfapp.databinding.FragmentDailyProjectsBinding
import com.example.nspsdfapp.utils.Data


class DailyProjectsFragment : Fragment() {
    lateinit var binding: FragmentDailyProjectsBinding
    lateinit var mainAdapter: HomeMainProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDailyProjectsBinding.inflate(
            LayoutInflater.from(context),
            container,
            false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = HomeMainProjectAdapter("history")
        setUpRecyclerView()
        mainAdapter.setItems(Data.getProjects())
    }

    private fun setUpRecyclerView() = with(binding) {
        rvProjects.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainAdapter
        }
    }

}