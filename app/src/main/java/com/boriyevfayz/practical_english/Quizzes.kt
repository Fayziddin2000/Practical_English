package com.boriyevfayz.practical_english

data class Quizzes(
    val question: String = "",
    var rightAnswer: String = "",
    var wrongAnswers: ArrayList<String> = arrayListOf()
)
