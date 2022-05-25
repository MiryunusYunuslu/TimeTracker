package com.example.nspsdfapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nspsdfapp.databinding.ItemHomeProjectsListBinding
import com.example.nspsdfapp.model.ProjectModel

class HomeMainProjectAdapter :
    RecyclerView.Adapter<HomeMainProjectAdapter.ViewHolder>() {

    var projectsList = mutableListOf<ProjectModel>()

    class ViewHolder(private val binding: ItemHomeProjectsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceType", "SetTextI18n")
        fun bind(project: ProjectModel) = with(binding) {
            tvProjectName.text = project.projectName
            ivBackgroundProjectShape.setBackgroundColor(Color.parseColor(project.projectColor))
            tvTime.text = "00:${project.projectTime.first}:${project.projectTime.second}"


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeProjectsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("working")
        holder.bind(projectsList[position])

    }

    override fun getItemCount() = projectsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(projects: ArrayList<ProjectModel>) {
        projectsList.clear()
        projectsList.addAll(projects)
        notifyDataSetChanged()
    }
}