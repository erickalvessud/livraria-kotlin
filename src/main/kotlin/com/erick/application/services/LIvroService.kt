package com.erick.application.services

import com.erick.LivroReply
import com.erick.SalvaLivroRequest
import com.erick.adapters.persistence.entities.LivroEntity
import com.erick.adapters.persistence.repositories.LivroRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class LIvroService(private val livroRepository: LivroRepository) {

    fun findById(id: Long) : Optional<LivroReply> {
        return this.livroRepository.findById(id).map { livroEntity ->
            LivroReply.newBuilder()
                    .setId(livroEntity.id!!)
                    .setTitulo(livroEntity.titulo)
                    .build()
        }
    }

    fun salvaLivro(request: SalvaLivroRequest): LivroReply {
        val livroSalvo = this.livroRepository.save(LivroEntity(null, request.titulo))
        return LivroReply.newBuilder()
                .setId(livroSalvo.id!!)
                .setTitulo(livroSalvo.titulo)
                .build()
    }
}