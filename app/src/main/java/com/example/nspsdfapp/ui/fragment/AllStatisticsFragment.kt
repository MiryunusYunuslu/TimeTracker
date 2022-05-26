package com.example.nspsdfapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nspsdfapp.adapter.ViewPagerAdapter
import com.example.nspsdfapp.databinding.FragmentAllStatisticsBinding
import com.google.android.material.tabs.TabLayoutMediator

class AllStatisticsFragment : Fragment() {
    lateinit var binding: FragmentAllStatisticsBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllStatisticsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTabView()
        setUpClickListeners()
    }

    private fun setUpClickListeners() = with(binding) {
        ibReturnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initializeTabView() = with(binding) {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Daily"
                }
                1 -> {
                    tab.text = "Weekly"
                }
                2 -> {
                    tab.text = "Monthly"
                }
            }

        }.attach()


    }

}