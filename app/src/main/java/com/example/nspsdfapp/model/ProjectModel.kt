package com.example.nspsdfapp.model

data class ProjectModel(
    val projectColor: String,
    val projectName: String,
    var projectTime: Pair<String, String>,
    var projectRunning: Boolean
)