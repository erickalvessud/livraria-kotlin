package com.erick.adapters.grpc.endpoint

import com.erick.FindLivroRequest
import com.erick.LivroReply
import com.erick.LivroServiceGrpcKt
import com.erick.application.services.LIvroService
import javax.inject.Singleton

@Singleton
class LivroEndpoint (private val livroService: LIvroService) :LivroServiceGrpcKt.LivroServiceCoroutineImplBase() {

    @Override
    override suspend fun findLivroById(request: FindLivroRequest): LivroReply {
        println("findLIvroById ${request.id}")
        val livro = livroService.findById(request.id)
        return livro.get()
    }

}