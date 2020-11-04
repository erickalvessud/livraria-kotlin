package com.erick.adapters.persistence.entities

import javax.persistence.*

@Entity
class LivroEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @Column(length = 255, nullable = false)
        var titulo: String
){
    constructor(): this(null, "")
}