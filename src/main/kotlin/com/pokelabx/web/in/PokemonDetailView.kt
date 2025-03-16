package com.pokelabx.web.`in`

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PokemonDetailView(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilityEntryView>,
    val stats: List<StatEntryView>,
    val types: List<TypeEntryView>,
    val sprites: SpritesView
)

@Serdeable
data class AbilityEntryView(
    val ability: AbilityView,
    val isHidden: Boolean,
    val slot: Int
)

@Serdeable
data class AbilityView(
    val name: String,
    val url: String
)

@Serdeable
data class StatEntryView(
    val baseStat: Int,
    val effort: Int,
    val stat: StatView
)

@Serdeable
data class StatView(
    val name: String,
    val url: String
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