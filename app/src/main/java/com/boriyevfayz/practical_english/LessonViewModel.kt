package com.boriyevfayz.practical_english

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LessonViewModel :
    ViewModel() {
    private var _lessons: MutableLiveData<String> = MutableLiveData("")
    private var _lessonTitle: MutableLiveData<String> = MutableLiveData("")
    private var _lessonPage: MutableLiveData<Int> = MutableLiveData(0)

    val mLessons: LiveData<String> get() = _lessons
    val mLessonTitle: LiveData<String> get() = _lessonTitle
    val mLessonPage: LiveData<Int> get() = _lessonPage

    fun setLessons(lessons: String, lessonsTitle: String) {
        _lessons.value = lessons
        _lessonTitle.value = lessonsTitle
    }
    fun setLessonsPage(page:Int){
        _lessonPage.value = page
    }

}