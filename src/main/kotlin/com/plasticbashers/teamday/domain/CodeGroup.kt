package com.plasticbashers.teamday.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotEmpty

@Document
data class CodeGroup(
        @Id var id: String? =null,
        @JsonIgnore var loggedIn: Boolean? = false,
        @NotEmpty val users: List<User>,
        @NotEmpty val teamName: String,
        val score: ArrayList<Answer>? = arrayListOf()
)