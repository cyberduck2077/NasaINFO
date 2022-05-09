package com.example.nasainfo.data

data class OfADayData(
    val concept_tags: String,
    val concepts: Concepts,
    val date: String,
    val explanation: String,
    val resource: Resource,
    val title: String,
    val url: String
)