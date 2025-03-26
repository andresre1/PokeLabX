package com.pokelabx.service

data class PokemonDetail(
    val id: Long,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeEntry>,
    val sprites: Sprites
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