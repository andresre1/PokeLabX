package com.pokelabx.web.`in`

import com.pokelabx.service.*
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.scheduling.TaskExecutors.BLOCKING
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/pokemon")
class PokemonResource(
    private val pokemonQueryUseCase: PokemonQueryUseCase
) {

    @ExecuteOn(BLOCKING)
    @Get("/{idOrName}")
    fun getPokemonByIdOrName(@PathVariable idOrName: String): PokemonDetailView {
        return mapToPokemonDetailView(pokemonQueryUseCase.findByIdOrName(idOrName))
    }

    private fun mapToPokemonDetailView(pokemon: PokemonDetail): PokemonDetailView {
        return PokemonDetailView(
            id = pokemon.id,
            name = pokemon.name,
            height = pokemon.height,
            weight = pokemon.weight,
            types = pokemon.types.map { mapToTypeEntryView(it) },
            sprites = mapToSpritesView(pokemon.sprites),
        )
    }

    private fun mapToTypeEntryView(typeEntry: TypeEntry): TypeEntryView {
        return TypeEntryView(
            slot = typeEntry.slot,
            type = TypeView(typeEntry.type.name, typeEntry.type.url)
        )
    }

    private fun mapToSpritesView(sprites: Sprites): SpritesView {
        return SpritesView(sprites.frontDefault)
    }
}