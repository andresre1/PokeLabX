package com.pokelabx.web.`in`

import com.pokelabx.service.PokemonService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/pokemon")
class PokemonResource(private val pokemonService: PokemonService) {

    @Get(uri="/{id}")
    fun getPokemonById(@PathVariable id: String): String {
        return pokemonService.findById(UUID.fromString(id))
    }
    
}