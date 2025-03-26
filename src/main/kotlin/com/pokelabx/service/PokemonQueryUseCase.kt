package com.pokelabx.service

import com.pokelabx.UseCase
import com.pokelabx.web.out.*
import org.slf4j.LoggerFactory

@UseCase
class PokemonQueryUseCase(
    private val pokeApiClient: PokeApiClient
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(PokemonQueryUseCase::class.java)
    }

    fun findByIdOrName(idOrName: String): PokemonDetail {
        val pokemon = pokeApiClient.findByIdOrName(idOrName)
        return mapToPokemonDetail(pokemon)
    }

    private fun mapToPokemonDetail(pokemon: PokemonDetailResponse): PokemonDetail {
        return PokemonDetail(
            id = pokemon.id,
            name = pokemon.name,
            height = pokemon.height,
            weight = pokemon.weight,
            types = pokemon.types.map { mapToTypeEntry(it) },
            sprites = mapToSprites(pokemon.sprites),
        )
    }

    private fun mapToTypeEntry(typeEntry: TypeEntryResponse): TypeEntry {
        return TypeEntry(
            slot = typeEntry.slot,
            type = Type(typeEntry.type.name, typeEntry.type.url)
        )
    }

    private fun mapToSprites(sprites: SpritesResponse): Sprites {
        return Sprites(sprites.frontDefault)
    }
}