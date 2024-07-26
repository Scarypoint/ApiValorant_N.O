package com.beta.valorantapi.com
data class ValorantResponse(
    val data: List<Agents>
)

data class Agents(
    val displayName: String,
    val description: String,
    val displayIcon:String,
)

data class WeaponsResponse(
val data: List<Weapons>
)

data class Weapons(
    val displayName: String,
    val category: String,
    val displayIcon: String
)
data class MapsResponse(
    val data: List<Maps>
)
data class Maps(
    val displayName: String,
    val tacticalDescription: String,
    val splash: String,
)
data class SpraysResponse(
    val data: List<Sprays>
)
data class Sprays(
    val displayName: String,
    val fullTransparentIcon: String,
)
data class PlayerCardsResponse(
    val data: List<PlayerCards>
)
data class PlayerCards(
    val displayName: String,
    val largeArt: String,
)
// Agrega otros campos según la respuesta de tu API

//paso 2 people data

//paso 3 repository
