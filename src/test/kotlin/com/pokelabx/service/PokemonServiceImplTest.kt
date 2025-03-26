package com.pokelabx.service

import com.pokelabx.web.out.PokeApiClient
import com.pokelabx.web.out.PokemonDetailResponse
import com.pokelabx.web.out.SpritesResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PokemonServiceImplTest : StringSpec({

    val pokeApiClient: PokeApiClient = mockk()

    "should return pokemon when findByIdOrName is called with name" {
        val pokemonDetailResponse = PokemonDetailResponse(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            types = emptyList(),
            sprites = SpritesResponse("front_default_url")
        )

        every { pokeApiClient.findByIdOrName("bulbasaur") } returns pokemonDetailResponse

        val pokemonServiceWithMock = PokemonQueryUseCase(pokeApiClient)
        val result = pokemonServiceWithMock.findByIdOrName("bulbasaur")
        result.id shouldBe 1
        result.name shouldBe "bulbasaur"
        result.height shouldBe 7
        result.weight shouldBe 69

        verify { pokeApiClient.findByIdOrName("bulbasaur") }
    }

    "should return pokemon when findByIdOrName is called with id" {
        val pokemonDetailResponse = PokemonDetailResponse(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            types = emptyList(),
            sprites = SpritesResponse("front_default_url")
        )

        every { pokeApiClient.findByIdOrName("1") } returns pokemonDetailResponse

        val pokemonServiceWithMock = PokemonQueryUseCase(pokeApiClient)
        val result = pokemonServiceWithMock.findByIdOrName("1")
        result.id shouldBe 1
        result.name shouldBe "bulbasaur"
        result.height shouldBe 7
        result.weight shouldBe 69

        verify { pokeApiClient.findByIdOrName("1") }
    }

    "should return pokemon when findByIdOrName is called with another name" {
        val pokemonDetailResponse = PokemonDetailResponse(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            types = emptyList(),
            sprites = SpritesResponse("front_default_url_pikachu")
        )

        every { pokeApiClient.findByIdOrName("pikachu") } returns pokemonDetailResponse

        val pokemonServiceWithMock = PokemonQueryUseCase(pokeApiClient)
        val result = pokemonServiceWithMock.findByIdOrName("pikachu")
        result.id shouldBe 25
        result.name shouldBe "pikachu"
        result.height shouldBe 4
        result.weight shouldBe 60

        verify { pokeApiClient.findByIdOrName("pikachu") }
    }
})
