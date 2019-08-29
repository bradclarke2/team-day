package com.plasticbashers.teamday.repository

import com.plasticbashers.teamday.domain.CodeGroup
import org.springframework.data.mongodb.repository.MongoRepository


interface CodeGroupRepository: MongoRepository<CodeGroup, String>