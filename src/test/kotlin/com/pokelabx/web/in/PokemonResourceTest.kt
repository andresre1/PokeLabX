package com.pokelabx.web.`in`

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@MicronautTest(startApplication = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PokemonResourceTest {

    @Inject
    lateinit var pokemonResource: PokemonResource

    @Test
    fun `should return a valid pokemon`() {
        val pokemon = pokemonResource.getPokemonById(UUID.randomUUID().toString())

        assertEquals("Pikachu", pokemon)
    }
}