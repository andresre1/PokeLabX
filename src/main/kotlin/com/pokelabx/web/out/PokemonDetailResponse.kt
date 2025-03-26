package com.pokelabx.web.out

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PokemonDetailResponse(
    val id: Long,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeEntryResponse>,
    val sprites: SpritesResponse
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
    val frontDefault: String
)