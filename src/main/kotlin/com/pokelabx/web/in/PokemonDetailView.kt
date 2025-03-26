package com.pokelabx.web.`in`

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PokemonDetailView(
    val id: Long,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeEntryView>,
    val sprites: SpritesView
)

@Serdeable
data class TypeEntryView(
    val slot: Int,
    val type: TypeView
)

@Serdeable
data class TypeView(
    val name: String,
    val url: String
)

@Serdeable
data class SpritesView(
    val frontDefault: String?
)