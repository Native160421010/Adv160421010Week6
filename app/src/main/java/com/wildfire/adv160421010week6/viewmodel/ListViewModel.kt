package com.wildfire.adv160421010week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wildfire.adv160421010week6.model.Features
import com.wildfire.adv160421010week6.model.Legionnaire

class ListViewModel(application: Application): AndroidViewModel(application) {
    val legionnairesLD = MutableLiveData<ArrayList<Legionnaire>>()
    val legionnaireLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        legionnaireLoadErrorLD.value = false

        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/Legionnaires/Legionnaires.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val lType = object : TypeToken<List<Legionnaire>>() { }.type
                val result = Gson().fromJson<List<Legionnaire>>(it, lType)
                legionnairesLD.value = result as ArrayList<Legionnaire>?
                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                legionnaireLoadErrorLD.value = false
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

        legionnaireLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}