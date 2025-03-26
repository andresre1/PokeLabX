package com.pokelabx.web.`in`

import com.pokelabx.PostgresContainer
import com.pokelabx.service.PokemonDetail
import com.pokelabx.service.PokemonQueryUseCase
import io.kotest.core.extensions.install
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.testcontainers.JdbcDatabaseContainerExtension
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest5.MicronautKotest5Extension.getMock
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class PokemonResourceTest(
    @Client("/") private val client: HttpClient,
    private val pokemonQueryUseCase: PokemonQueryUseCase
) : StringSpec({

    "test getPokemonByIdOrName endpoint" {
        val pokemonDetail = PokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            types = emptyList(),
            sprites = com.pokelabx.service.Sprites("front_default_url")
        )

        val mock = getMock(pokemonQueryUseCase)
        every { mock.findByIdOrName(any()) } returns pokemonDetail

        val response = client.toBlocking().exchange(
            HttpRequest.GET<Any>("/pokemon/bulbasaur"),
            PokemonDetailView::class.java
        )

        response.status shouldBe HttpStatus.OK
        val body = response.body.get()
        body.id shouldBe 1
        body.name shouldBe "bulbasaur"
        body.height shouldBe 7
        body.weight shouldBe 69
    }
}) {

    @MockBean(PokemonQueryUseCase::class)
    fun pokemonService(): PokemonQueryUseCase {
        return mockk()
    }
}