package com.pokelabx.domain

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity("type_entry")
data class TypeEntryEntity(
    @field:Id
    @field:GeneratedValue(GeneratedValue.Type.IDENTITY)
    val id: Long? = null,

    var pokemonId: Int,
    val slot: Int,
    val typeName: String,
    val typeUrl: String
)
