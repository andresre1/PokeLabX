package com.pokelabx.web.`in`

import com.pokelabx.service.*
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.scheduling.TaskExecutors.BLOCKING
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/pokemon")
class PokemonResource(
    private val pokemonService: PokemonService
) {

    @ExecuteOn(BLOCKING)
    @Get("/{idOrName}")
    fun getPokemonByIdOrName(@PathVariable idOrName: String): PokemonDetailView {
        return mapToPokemonDetailView(pokemonService.findByIdOrName(idOrName))
    }

    private fun mapToPokemonDetailView(pokemon: PokemonDetail): PokemonDetailView {
        return PokemonDetailView(
            id = pokemon.id,
            name = pokemon.name,
            height = pokemon.height,
            weight = pokemon.weight,
            abilities = pokemon.abilities.map { mapToAbilityEntryView(it) },
            stats = pokemon.stats.map { mapToStatEntryView(it) },
            types = pokemon.types.map { mapToTypeEntryView(it) },
            sprites = mapToSpritesView(pokemon.sprites)
        )
    }

    private fun mapToAbilityEntryView(abilityEntry: AbilityEntry): AbilityEntryView {
        return AbilityEntryView(
            ability = AbilityView(abilityEntry.ability.name, abilityEntry.ability.url),
            isHidden = abilityEntry.isHidden,
            slot = abilityEntry.slot
        )
    }

    private fun mapToStatEntryView(statEntry: StatEntry): StatEntryView {
        return StatEntryView(
            baseStat = statEntry.baseStat,
            effort = statEntry.effort,
            stat = StatView(statEntry.stat.name, statEntry.stat.url)
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