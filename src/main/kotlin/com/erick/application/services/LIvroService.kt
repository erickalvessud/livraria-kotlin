package com.erick.application.services

import com.erick.LivroReply
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
}