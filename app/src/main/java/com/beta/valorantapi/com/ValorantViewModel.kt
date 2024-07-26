package com.beta.valorantapi.com

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.beta.valorantapi.com.ApiEndPoints.ValorantAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ValorantViewModel(application: Application) : AndroidViewModel(application) {

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val apiService = Retrofit.Builder()
        .baseUrl("https://valorant-api.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(ValorantAPI::class.java)

    private val repository = ValorantRepository(apiService)

    private val _agentsList = MutableStateFlow<List<Agents>>(emptyList())
    val agentsList: StateFlow<List<Agents>> = _agentsList.asStateFlow()

    private val _weaponList = MutableStateFlow<List<Weapons>>(emptyList())
    val weaponsList: StateFlow<List<Weapons>> = _weaponList.asStateFlow()

    private val _mapList = MutableStateFlow<List<Maps>>(emptyList())
    val mapsList: StateFlow<List<Maps>> = _mapList.asStateFlow()

    private val _sprayList = MutableStateFlow<List<Sprays>>(emptyList())
    val spraysList: StateFlow<List<Sprays>> = _sprayList.asStateFlow()

    private val _cardList = MutableStateFlow<List<PlayerCards>>(emptyList())
    val cardsList: StateFlow<List<PlayerCards>> = _cardList.asStateFlow()

    init {
        fetchValorant()
        fetchWeapons()
        fetchMaps()
        fetchSprays()
        fetchPlayerCards()
    }

    private fun fetchValorant() = viewModelScope.launch {
        _agentsList.value = repository.GetValorant()
    }

    private fun fetchWeapons() = viewModelScope.launch {
        _weaponList.value = repository.GetWeapons()
    }

    private fun fetchMaps() = viewModelScope.launch {
        _mapList.value = repository.GetMaps()
    }

    private fun fetchSprays() = viewModelScope.launch {
        _sprayList.value = repository.GetSprays()
    }

    private fun fetchPlayerCards() = viewModelScope.launch {
        _cardList.value = repository.GetPlayerCards()
    }
}



