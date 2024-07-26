package com.beta.valorantapi.com

import com.beta.valorantapi.com.ApiEndPoints.ValorantAPI

class ValorantRepository (private val apiService: ValorantAPI) {

    suspend fun GetValorant(): List<Agents> {
        return apiService.getValorant().data
    }

    suspend fun GetWeapons(): List<Weapons> {
        return apiService.getWeapons().data
    }

    suspend fun GetMaps(): List<Maps> {
        return apiService.getMaps().data
    }

    suspend fun GetSprays(): List<Sprays> {
        return apiService.getSprays().data
    }

    suspend fun GetPlayerCards(): List<PlayerCards> {
        return apiService.getPlayerCards().data
    }
}
