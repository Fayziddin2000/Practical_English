package com.boriyevfayz.practical_english

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LessonViewModel :
    ViewModel() {
    private var _lessons: MutableLiveData<String> = MutableLiveData("")
    private var _lessonTitle: MutableLiveData<String> = MutableLiveData("")
    private var _lessonUrl: MutableLiveData<String> = MutableLiveData("")

    val mLessons: LiveData<String> get() = _lessons
    val mLessonTitle: LiveData<String> get() = _lessonTitle
    val mLessonUrl: LiveData<String> get() = _lessonUrl

    fun setLessons(lessons: String, lessonsTitle: String) {
        _lessons.value = lessons
        _lessonTitle.value = lessonsTitle
    }

    fun setLessonsUrl(lessonsUrl: String) {
        _lessonUrl.value = lessonsUrl
    }

}