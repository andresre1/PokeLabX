package com.pokelabx.service

import jakarta.inject.Singleton
import java.util.UUID

@Singleton
class PokemonService {

    fun findById(id: UUID): String {
        return "test"
    }
}