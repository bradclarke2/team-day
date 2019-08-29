package com.plasticbashers.teamday.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Answer (
    @Id var id: String? =null,
    val answerMatcher:String
)
