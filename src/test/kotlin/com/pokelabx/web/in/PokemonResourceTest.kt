package com.pokelabx.web.`in`

import com.pokelabx.service.PokemonDetail
import com.pokelabx.service.PokemonService
import io.kotest.core.spec.style.StringSpec
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
    private val pokemonService: PokemonService,
    @Client("/") private val client: HttpClient
) : StringSpec({

    "test getPokemonByIdOrName endpoint" {
        val pokemonDetail = PokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            abilities = listOf(
                com.pokelabx.service.AbilityEntry(
                    ability = com.pokelabx.service.Ability(name = "overgrow", url = "ability_url"),
                    isHidden = false,
                    slot = 1
                )
            ),
            stats = listOf(
                com.pokelabx.service.StatEntry(
                    baseStat = 49,
                    effort = 0,
                    stat = com.pokelabx.service.Stat(name = "attack", url = "stat_url")
                )
            ),
            types = listOf(
                com.pokelabx.service.TypeEntry(
                    slot = 1,
                    type = com.pokelabx.service.Type(name = "grass", url = "type_url")
                )
            ),
            sprites = com.pokelabx.service.Sprites("front_default_url")
        )

        val mock = getMock(pokemonService)
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
        body.abilities.size shouldBe 1
        body.abilities[0].ability.name shouldBe "overgrow"
        body.abilities[0].ability.url shouldBe "ability_url"
        body.abilities[0].isHidden shouldBe false
        body.abilities[0].slot shouldBe 1
        body.stats.size shouldBe 1
        body.stats[0].baseStat shouldBe 49
        body.stats[0].effort shouldBe 0
        body.stats[0].stat.name shouldBe "attack"
        body.stats[0].stat.url shouldBe "stat_url"
        body.types.size shouldBe 1
        body.types[0].slot shouldBe 1
        body.types[0].type.name shouldBe "grass"
        body.types[0].type.url shouldBe "type_url"
        body.sprites.frontDefault shouldBe "front_default_url"
    }
}) {

    @MockBean(PokemonService::class)
    fun pokemonService(): PokemonService {
        return mockk()
    }
}