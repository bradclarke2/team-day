package com.plasticbashers.teamday.handler

import com.plasticbashers.teamday.api.requests.Login
import com.plasticbashers.teamday.repository.AnswerRepository
import com.plasticbashers.teamday.repository.CodeGroupRepository
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.stereotype.Component

@Component
class ClueHandler(
        private val codeGroupRepository: CodeGroupRepository,
        private val answerRepository: AnswerRepository
) {

    fun loginGroup(login: Login, id: String): ResponseEntity<String> {
        val codeGroup = codeGroupRepository.findById(id)
        if (!codeGroup.isPresent) return notFound().build()
        val loggedInCodeGroup = codeGroup.get()
        if (loggedInCodeGroup.loggedIn == true) return ok().body("you are already logged in")

        return when (login.password) {
            // intentionally insecure this is a training exercise
            PASSWORD -> {
                loggedInCodeGroup.loggedIn = true
                val loginAnswer = answerRepository.findAll().firstOrNull { it.answerMatcher == "loggedIn" }
                if (loginAnswer != null) loggedInCodeGroup.score?.add(loginAnswer)
                codeGroupRepository.save(loggedInCodeGroup)
                ok().body("success")
            }
            else -> status(UNAUTHORIZED).body("password is more secure than that its $PASSWORD 🤦")
        }
    }

    fun submitAnswer(id: String, clue: String): ResponseEntity<String> {
        val codeGroup = codeGroupRepository.findById(id)
        if (!codeGroup.isPresent) return notFound().build()
        val loggedInCodeGroup = codeGroup.get()

        val answer = answerRepository.findAll().firstOrNull { it.answerMatcher == clue }

        return if (answer === null) status(NOT_FOUND).body("that is not the correct answer")
        else
            when (loggedInCodeGroup.score?.any { it.id == answer.id }) {
                false -> {
                    loggedInCodeGroup.score.add(answer)
                    codeGroupRepository.save(loggedInCodeGroup)
                    ok().body("success")
                }
                else -> status(NOT_FOUND).body("you've already got that answer....cheeky")
            }
    }

    companion object {
        const val PASSWORD = "1235"
    }
}
