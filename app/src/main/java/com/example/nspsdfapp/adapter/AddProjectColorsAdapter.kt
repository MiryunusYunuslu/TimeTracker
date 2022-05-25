package com.example.nspsdfapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nspsdfapp.databinding.ItemAddColorsListBinding
import com.example.nspsdfapp.utils.Constants.SELECTED_COLOR

class AddProjectColorsAdapter(private val colorsList: List<String>) :
    RecyclerView.Adapter<AddProjectColorsAdapter.ViewHolder>() {
    private var selectedKey = 0

    class ViewHolder(val binding: ItemAddColorsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceType")
        fun bind(color: String) = with(binding) {
            SELECTED_COLOR = color

            ibColor.setBackgroundColor(Color.parseColor(color))
        }

        fun makeSelectedVisible(color: String) = with(binding) {
            viewSelectedColor.setBackgroundColor(Color.parseColor(color))
            cardViewSelected.visibility = View.VISIBLE
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAddColorsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(colorsList[position])
        if (position == selectedKey) {
            holder.makeSelectedVisible(colorsList[position])
        } else {
            holder.binding.cardViewSelected.visibility = View.INVISIBLE
        }
        holder.binding.ibColor.setOnClickListener {
            selectedKey = position

            notifyDataSetChanged()

        }

    }

    override fun getItemCount() = colorsList.size


}