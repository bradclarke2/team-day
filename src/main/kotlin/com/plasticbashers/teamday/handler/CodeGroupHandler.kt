package com.plasticbashers.teamday.handler

import com.plasticbashers.teamday.domain.CodeGroup
import com.plasticbashers.teamday.repository.CodeGroupRepository
import org.springframework.stereotype.Component

@Component
class CodeGroupHandler(private val codeGroupRepository: CodeGroupRepository) {

    fun createCodeGroup(codeGroup: CodeGroup):CodeGroup = codeGroupRepository.save(codeGroup)

    fun getCodeGroups(): List<CodeGroup> = codeGroupRepository.findAll()
}