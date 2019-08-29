package com.plasticbashers.teamday.repository

import com.plasticbashers.teamday.domain.Answer
import org.springframework.data.mongodb.repository.MongoRepository


interface AnswerRepository: MongoRepository<Answer, String> {
}