package com.pokelabx.web.out

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

@Serdeable
data class PokemonResult(
    val name: String,
    val url: String
)