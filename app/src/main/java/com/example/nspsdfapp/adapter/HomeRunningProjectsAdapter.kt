package com.example.nspsdfapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nspsdfapp.R
import com.example.nspsdfapp.databinding.ItemHomeRunningProjectsBinding
import com.example.nspsdfapp.model.ProjectModel

class HomeRunningProjectsAdapter :
    RecyclerView.Adapter<HomeRunningProjectsAdapter.ViewHolder>() {
    var projects = mutableListOf<ProjectModel>()
    //var isChronometerRunning = false
    // lateinit var projectModel: ProjectModel

    inner class ViewHolder(private val binding: ItemHomeRunningProjectsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceType")
        fun bind(project: ProjectModel) = with(binding) {
            tvProjectName.text = project.projectName
            chronometerProjectRunningTime.base =
                SystemClock.elapsedRealtime() - (project.projectTime.first.toLong() * 60000 + project.projectTime.second.toLong() * 1000)
        }

        fun setClickListener(projectModel: ProjectModel, position: Int) = with(binding) {
            ivProjectStart.setOnClickListener {
                if (projectModel.projectRunning) {
                    ivProjectStart.setBackgroundResource(R.drawable.ic_play)
                    println(chronometerProjectRunningTime.text)
                    updateValues(position)
                    chronometerProjectRunningTime.stop()
                    projectModel.projectRunning = false
                } else {
                    ivProjectStart.setBackgroundResource(R.color.white)

                    chronometerProjectRunningTime.base = SystemClock.elapsedRealtime() - (projectModel.projectTime.first.toLong() * 60000 + projectModel.projectTime.second.toLong() * 1000)
                    chronometerProjectRunningTime.start()
                    projectModel.projectRunning = true
                }
            }
        }

        private fun updateValues(position: Int) = with(binding) {
            projects[position].projectTime = Pair(
                chronometerProjectRunningTime.text.substring(0, 2),
                chronometerProjectRunningTime.text.substring(
                    3,
                    chronometerProjectRunningTime.text.length
                )
            )
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeRunningProjectsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setBackgroundColor(Color.parseColor(projects[position].projectColor))
        holder.bind(projects[position])
        holder.setClickListener(projects[position], position)
    }

    override fun getItemCount() = projects.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(projectsList: ArrayList<ProjectModel>) {
        projects.clear()
        projects.addAll(projectsList)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        for (i in projects.indices) {
            projects.removeAt(0)
            notifyItemRemoved(0)
        }

    }


}