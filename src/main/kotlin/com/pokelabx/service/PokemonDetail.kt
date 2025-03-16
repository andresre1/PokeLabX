package com.pokelabx.service

data class PokemonDetail(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilityEntry>,
    val stats: List<StatEntry>,
    val types: List<TypeEntry>,
    val sprites: Sprites
)

data class AbilityEntry(
    val ability: Ability,
    val isHidden: Boolean,
    val slot: Int
)

data class Ability(
    val name: String,
    val url: String
)

data class StatEntry(
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)

data class TypeEntry(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class Sprites(
    val frontDefault: String?
)