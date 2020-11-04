package com.erick.application.services

import com.erick.LivroReply
import com.google.common.base.Optional
import javax.inject.Singleton

@Singleton
class LIvroService() {

    public fun findById(id: Long) : Optional<LivroReply> {
        val livro = LivroReply.newBuilder().setId(1).setTitulo("Kotlin").build()
        return Optional.of(livro)
    }
}