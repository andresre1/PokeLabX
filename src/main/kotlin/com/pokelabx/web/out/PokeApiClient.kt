package com.pokelabx.web.out

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(id = "pokeapi")
interface PokeApiClient {

    @Get("/pokemon?limit={limit}&offset={offset}")
    fun findAll(limit: Int, offset: Int): PokemonListResponse

    @Get("/pokemon/{idOrName}")
    fun findByIdOrName(idOrName: String): PokemonDetailResponse
}