package com.pokelabx.web.out

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilityEntryResponse>,
    val stats: List<StatEntryResponse>,
    val types: List<TypeEntryResponse>,
    val sprites: SpritesResponse
)

@Serdeable
data class AbilityEntryResponse(
    val ability: AbilityResponse,
    @JsonProperty("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)

@Serdeable
data class AbilityResponse(
    val name: String,
    val url: String
)

@Serdeable
data class StatEntryResponse(
    @JsonProperty("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: StatResponse
)

@Serdeable
data class StatResponse(
    val name: String,
    val url: String
)

@Serdeable
data class TypeEntryResponse(
    val slot: Int,
    val type: TypeResponse
)

@Serdeable
data class TypeResponse(
    val name: String,
    val url: String
)

@Serdeable
data class SpritesResponse(
    @JsonProperty("front_default")
    val frontDefault: String?
)