package com.pokelabx.service

interface PokemonService {

    fun findByIdOrName(idOrName: String): PokemonDetail
}