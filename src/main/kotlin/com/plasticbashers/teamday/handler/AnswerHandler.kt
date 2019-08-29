package com.plasticbashers.teamday.handler

import com.plasticbashers.teamday.domain.Answer
import com.plasticbashers.teamday.repository.AnswerRepository
import org.springframework.stereotype.Component

@Component
class AnswerHandler (private val answerRepository: AnswerRepository) {
    fun createAnswer(answer: Answer) = answerRepository.save(answer)
    fun getNumberOfAnswers(): Int = answerRepository.findAll().size
}
