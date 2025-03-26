package com.pokelabx.service

import com.pokelabx.UseCase
import com.pokelabx.persistence.PokemonMapper
import com.pokelabx.persistence.PokemonRepository
import com.pokelabx.web.out.PokeApiClient

@UseCase
class PokemonCreateUseCase(
    private val pokeApiClient: PokeApiClient,
    private val pokemonRepository: PokemonRepository,
    private val pokemonMapper: PokemonMapper
) {

    fun saveAll() {
        val pokemonList = pokeApiClient.findAll(100, 0)

        val pokemonDetails = pokemonList.results.mapNotNull { result ->
            try {
                val detail = pokeApiClient.findByUrl(result.url)
                pokemonMapper.mapToEntity(detail)
            } catch (e: Exception) {
                null
            }
        }
        pokemonRepository.saveAll(pokemonDetails)
    }
}