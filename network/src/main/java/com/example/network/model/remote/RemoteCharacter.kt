package com.example.network.model.remote

import com.example.network.model.domain.Character
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacter(
    val id: Int?,
    val name: String?,
    // This brings back status ->, Options are: Alive, Dead, unknown
    val status: String?,
    val species: String?,
    val type: String?,
    // This brings back gender ->, Options are: Female, Male, Genderless, unknown
    val gender: String?,
    val origin: Origin?,
    val location: Location?,
    val image: String?,
    val episode: List<String>?,
    val url: String?,
    val created: String?
) {

    @Serializable
    data class Origin(
        val name: String?,
        val url: String?
    )

    @Serializable
    data class Location(
        val name: String?,
        val url: String?
    )
}

fun RemoteCharacter.toDomainCharacter(): Character {
    val characterGender = when (gender?.lowercase()) {
        "male" -> CharacterGender.Male
        "female" -> CharacterGender.Female
        "genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    }

    val characterStatus = when (status?.lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }

    return Character(
        created = created,
        episodeUrls = episode,
        gender = characterGender,
        id = id,
        imageUrl = image,
        location = Character.Location(name = location?.name, url = location?.url),
        name = name,
        origin = Character.Origin(name = origin?.name, url = origin?.url),
        species = species,
        status = characterStatus,
        type = type
    )
}
