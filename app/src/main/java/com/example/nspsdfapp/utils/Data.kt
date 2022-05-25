package com.example.nspsdfapp.utils

import com.example.nspsdfapp.model.ProjectModel

object Data {
    private var projects = arrayListOf<ProjectModel>(
        ProjectModel("#02AFA5", "PayPark", Pair("12", "40"), false),
        ProjectModel("#DD8470", "Courier", Pair("34", "50"), false),
        ProjectModel("#1B7534", "Courier", Pair("31", "23"), false)
    )

    fun getProjects() = projects

    fun checkUserLogin(userName: String, userPassword: String): Boolean {
        if (userName == "Yunus" && userPassword == "yunus12345") return true
        if (userName == "Yusif" && userPassword == "yusif14") return true
        if (userName == "Eldaniz" && userPassword == "hovsan1234") return true
        return false
    }

    fun addProject(projectModel: ProjectModel) {
        projects.add(projectModel)
    }
}