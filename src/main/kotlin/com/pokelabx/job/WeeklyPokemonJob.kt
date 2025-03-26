package com.pokelabx.job

import com.pokelabx.service.PokemonCreateUseCase
import io.micronaut.scheduling.annotation.Scheduled
import jakarta.inject.Singleton

@Singleton
class WeeklyPokemonJob(
    private val pokemonCreateUseCase: PokemonCreateUseCase
) {

    @Scheduled(cron = "0 30 4 ? * MON")
    fun execute() {
        pokemonCreateUseCase.saveAll()
    }
}