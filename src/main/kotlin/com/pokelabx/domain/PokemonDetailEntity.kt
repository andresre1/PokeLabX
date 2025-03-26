package com.pokelabx.domain

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity("pokemon_detail")
data class PokemonDetailEntity(
    @field:Id
    val id: Long,

    val name: String,
    val height: Int,
    val weight: Int,
    val spriteUrl: String
)
