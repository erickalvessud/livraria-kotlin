package com.erick.adapters.persistence.repositories

import com.erick.adapters.persistence.entities.LivroEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface LivroRepository : JpaRepository<LivroEntity, Long>{
}