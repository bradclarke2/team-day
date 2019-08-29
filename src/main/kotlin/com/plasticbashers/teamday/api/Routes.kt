package com.plasticbashers.teamday.api

import com.plasticbashers.teamday.api.requests.Login
import com.plasticbashers.teamday.domain.Answer
import com.plasticbashers.teamday.domain.CodeGroup
import com.plasticbashers.teamday.handler.AnswerHandler
import com.plasticbashers.teamday.handler.ClueHandler
import com.plasticbashers.teamday.handler.CodeGroupHandler
import org.springframework.web.bind.annotation.*

@RestController
class Routes(
        private val codeGroupHandler: CodeGroupHandler,
        private val clueHandler: ClueHandler,
        private val answerHandler: AnswerHandler
) {
    @CrossOrigin
    @GetMapping("/hello")
    fun hello() = "hello"

    @CrossOrigin
    @PostMapping("/code-group")
    fun createCodeGroup(@RequestBody codeGroup: CodeGroup): CodeGroup = codeGroupHandler.createCodeGroup(codeGroup)

    @CrossOrigin
    @GetMapping("/code-group")
    fun getCodeGroups(): List<CodeGroup> = codeGroupHandler.getCodeGroups()

    @CrossOrigin
    @PostMapping("/code-group/{id}/login")
    fun loginGroup(@RequestBody login: Login, @PathVariable("id") id:String) = clueHandler.loginGroup(login, id)

    @CrossOrigin
    @PutMapping("/code-group/{id}/answers/{clue}")
    fun submitAnswer(@PathVariable("id") id:String, @PathVariable("clue") clue:String) = clueHandler.submitAnswer(id, clue)

    @CrossOrigin
    @PostMapping("/answers")
    fun createAnswer(@RequestBody answer: Answer) = answerHandler.createAnswer(answer)

    @CrossOrigin
    @GetMapping("/answers")
    fun getNumberOfAnswers():Int = answerHandler.getNumberOfAnswers()
}
