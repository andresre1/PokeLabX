package com.pokelabx.persistence

import com.pokelabx.domain.PokemonDetailEntity
import com.pokelabx.domain.TypeEntryEntity
import com.pokelabx.web.out.PokemonDetailResponse
import jakarta.inject.Singleton

@Singleton
class PokemonMapper {

    fun mapToEntity(response: PokemonDetailResponse): PokemonDetailEntity {
        return PokemonDetailEntity(
            id = response.id,
            name = response.name,
            height = response.height,
            weight = response.weight,
            spriteUrl = response.sprites.frontDefault
        )
    }

    fun mapTypes(response: PokemonDetailResponse): List<TypeEntryEntity> {
        return response.types.map { typeEntry ->
            TypeEntryEntity(
                id = null,
                pokemonId = response.id.toInt(),
                slot = typeEntry.slot,
                typeName = typeEntry.type.name,
                typeUrl = typeEntry.type.url
            )
        }
    }
}