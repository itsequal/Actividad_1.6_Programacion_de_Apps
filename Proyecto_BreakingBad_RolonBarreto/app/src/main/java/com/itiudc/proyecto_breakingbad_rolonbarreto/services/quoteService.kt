package com.itiudc.proyecto_breakingbad_rolonbarreto.services


import com.itiudc.proyecto_breakingbad_rolonbarreto.api.Response1
import com.itiudc.proyecto_breakingbad_rolonbarreto.api.api
import retrofit2.http.GET
import retrofit2.http.Path

interface quoteService {

    @GET("quote/random")
    suspend fun getQuotes(): Response1
}

var quoteServices: quoteService = api.create<quoteService>(quoteService::class.java)
