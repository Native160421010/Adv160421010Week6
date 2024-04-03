package com.wildfire.adv160421010week6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildfire.adv160421010week6.model.Features
import com.wildfire.adv160421010week6.model.Legionnaire

class ListViewModel: ViewModel() {
    val legionnairesLD = MutableLiveData<ArrayList<Legionnaire>>()
    val legionnaireLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        legionnairesLD.value = arrayListOf(
            Legionnaire(
                id = "1",
                codename = "Cosmic Boy",
                name = "Rokk Krinn",
                birthday = "Feb. 11, 2958",
                power = "Super-Magnetism",
                joined = "Jan. 6, 2973",
                planet = "Braal",
                features = Features(
                    hair = "Coal Black",
                    eyes = "Clear, uncompromising blue",
                    height = "6' 0'",
                    weight = "190"
                ),
                hobbies = listOf("Magnoball", "20th century memorabilia", "whistling", "Kujui"),
                ambition = "To be the best I can be",
                tree = "I hope a strong one that provides others with shelter",
                change = "More disciplined"
            ),
            Legionnaire(
                id = "2",
                codename = "Saturn Girl",
                name = "Imra Ardeen",
                birthday = "Nov. 23, 2958",
                power = "Super-Telepathy",
                joined = "Jan. 6, 2973",
                planet = "Titan",
                features = Features(
                    hair = "Golden flowing blond",
                    eyes = "Clear, intelligent blue",
                    height = "5' 7'",
                    weight = "130"
                ),
                hobbies = listOf("Reading", "swimming", "hoops", "historical simulations"),
                ambition = "To make the universe a better place for all sentience",
                tree = "A Winathian Demi-Violet, because they seem tough and sturdy on the outside, but are also soft and gentle when they blossom",
                change = "Spending eight hours a night asleep when there's so much to be done"
            ),
            Legionnaire(
                id = "3",
                codename = "Lightning Lad",
                name = "Garth Ranzz",
                birthday = "Nov. 10, 2959",
                power = "Super-Lightning",
                joined = "Jan. 6, 2973",
                planet = "Winath",
                features = Features(
                    hair = "Dazzling red",
                    eyes = "Electric blue",
                    height = "6' 2'",
                    weight = "190"
                ),
                hobbies = listOf("Rocket-sled racing", "girl watching", "gridball", "hoops", "hunting", "bronc-riding"),
                ambition = "To clean up all the trash that makes the Legion necessary",
                tree = "A Fire Palm. Bright, beautiful, and it'll never die.",
                change = "My irresistibility to women."
            )
        )
        legionnaireLoadErrorLD.value = false
        loadingLD.value = false
    }


}