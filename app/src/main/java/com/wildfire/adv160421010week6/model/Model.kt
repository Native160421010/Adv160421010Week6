package com.wildfire.adv160421010week6.model

// The data (Legionnaires.json) is available on this github
data class Legionnaire(
    var id: String?,
    var codename: String?,
    var name: String?,
    var birthday: String?,
    var power: String?,
    var joined: String?,
    var planet: String?,
    var features: Features?,
    var hobbies: List<String>?,
    var ambition: String?,
    var tree: String?,
    var change: String?,
    var images: String?
)

data class Features(
    var hair: String?,
    var eyes: String?,
    var height: String?,
    var weight: String?
)
