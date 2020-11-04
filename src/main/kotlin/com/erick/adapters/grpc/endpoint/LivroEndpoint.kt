package com.erick.adapters.grpc.endpoint

import com.erick.FindLivroRequest
import com.erick.LivroReply
import com.erick.LivroServiceGrpcKt
import com.erick.SalvaLivroRequest
import com.erick.application.services.LIvroService
import io.grpc.Status
import javax.inject.Singleton

@Singleton
class LivroEndpoint (private val livroService: LIvroService) :LivroServiceGrpcKt.LivroServiceCoroutineImplBase() {

    @Override
    override suspend fun findLivroById(request: FindLivroRequest): LivroReply {
        println("findLIvroById ${request.id}")
        val livro = this.livroService.findById(request.id)
        if(!livro.isPresent) {
            trataLivroNaoEncontrado(request.id)
        }
        return livro.get()
    }

    override suspend fun salvaLivro(request: SalvaLivroRequest): LivroReply {
        return this.livroService.salvaLivro(request)
    }

    private fun trataLivroNaoEncontrado(id: Long) {
        val mensagemErro = "LIvro com ${id} nao encontrado"
        println(mensagemErro)
        throw Status.NOT_FOUND
                .withDescription(mensagemErro)
                .asException()
    }

}