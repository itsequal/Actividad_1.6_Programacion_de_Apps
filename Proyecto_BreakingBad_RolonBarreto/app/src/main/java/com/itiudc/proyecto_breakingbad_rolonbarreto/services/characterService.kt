package com.itiudc.proyecto_breakingbad_rolonbarreto.services

import com.itiudc.proyecto_breakingbad_rolonbarreto.api.Response
import com.itiudc.proyecto_breakingbad_rolonbarreto.api.api
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import retrofit2.http.GET

interface characterService {

    @GET("characters")
    suspend fun getCharacters(): Response
}

var characterServices: characterService = api.create<characterService>(characterService::class.java)
