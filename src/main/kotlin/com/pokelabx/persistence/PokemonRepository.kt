package com.pokelabx.persistence

import com.pokelabx.domain.PokemonDetailEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface PokemonRepository : CrudRepository<PokemonDetailEntity, Long> {}
