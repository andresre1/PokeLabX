package com.pokelabx.service

import com.pokelabx.web.out.*
import jakarta.inject.Singleton

@Singleton
internal class PokemonServiceImpl(private val pokeApiClient: PokeApiClient) : PokemonService{

    override fun findByIdOrName(idOrName: String): PokemonDetail {
        val pokemon = pokeApiClient.findByIdOrName(idOrName)
        return mapToPokemonDetail(pokemon)
    }

    private fun mapToPokemonDetail(pokemon: PokemonDetailResponse): PokemonDetail {
        return PokemonDetail(
            id = pokemon.id,
            name = pokemon.name,
            height = pokemon.height,
            weight = pokemon.weight,
            abilities = pokemon.abilities.map { mapToAbilityEntry(it) },
            stats = pokemon.stats.map { mapToStatEntry(it) },
            types = pokemon.types.map { mapToTypeEntry(it) },
            sprites = mapToSprites(pokemon.sprites)
        )
    }

    private fun mapToAbilityEntry(abilityEntry: AbilityEntryResponse): AbilityEntry {
        return AbilityEntry(
            ability = Ability(abilityEntry.ability.name, abilityEntry.ability.url),
            isHidden = abilityEntry.isHidden,
            slot = abilityEntry.slot
        )
    }

    private fun mapToStatEntry(statEntry: StatEntryResponse): StatEntry {
        return StatEntry(
            baseStat = statEntry.baseStat,
            effort = statEntry.effort,
            stat = Stat(statEntry.stat.name, statEntry.stat.url)
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