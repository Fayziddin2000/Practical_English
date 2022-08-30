package com.boriyevfayz.practical_english

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.Exception

class MainViewModel : ViewModel() {

    private val _quizzesList: MutableLiveData<List<Quizzes>> = MutableLiveData<List<Quizzes>>()
    private val _errorLiveData: MutableLiveData<String> = MutableLiveData<String>()

    private val _currentQuestionNumber: MutableLiveData<Int> = MutableLiveData(1)
    private val _rightAnswersCount: MutableLiveData<Int> = MutableLiveData(0)

    private var _lessons: MutableLiveData<String> = MutableLiveData("")
    private var _lessonTitle: MutableLiveData<String> = MutableLiveData("")

    val mCurrentQuestion: LiveData<Int> get() = _currentQuestionNumber
    val mRightAnswerCount: LiveData<Int> get() = _rightAnswersCount

    val mQuizzesList: LiveData<List<Quizzes>> get() = _quizzesList
    val mErrorLiveData: LiveData<String> get() = _errorLiveData

    val mLessons: LiveData<String> get() = _lessons
    val mLessonTitle: LiveData<String> get() = _lessonTitle

    fun onRightAnswer() {
        _rightAnswersCount.value = _rightAnswersCount.value!! + 1
    }

    fun nextQuestion() {
        _currentQuestionNumber.value = _currentQuestionNumber.value!! + 1
    }

    fun finish() {
        _currentQuestionNumber.value = 11
    }

    fun setDefaultValues() {
        _currentQuestionNumber.value = 1
        _rightAnswersCount.value = 0
    }

    fun setLessons(lessons: String, lessonsTittle: String) {
        _lessons.value = lessons
        _lessonTitle.value = lessonsTittle
    }
}