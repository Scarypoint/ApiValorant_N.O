package com.beta.valorantapi.com.ApiEndPoints




import com.beta.valorantapi.com.MapsResponse
import com.beta.valorantapi.com.PlayerCardsResponse
import com.beta.valorantapi.com.SpraysResponse
import com.beta.valorantapi.com.ValorantResponse
import com.beta.valorantapi.com.WeaponsResponse
import retrofit2.http.GET

interface ValorantAPI {
    @GET("agents")
    suspend fun getValorant():ValorantResponse

    @GET("weapons")
suspend fun getWeapons(): WeaponsResponse

    @GET("maps")
    suspend fun getMaps(): MapsResponse

    @GET("sprays")
    suspend fun getSprays(): SpraysResponse

    @GET("playercards")
    suspend fun getPlayerCards(): PlayerCardsResponse
}