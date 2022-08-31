package com.boriyevfayz.practical_english

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideosUrlViewModel : ViewModel() {

    private var _videosUrl: MutableLiveData<String> = MutableLiveData("")

    val mVideosUrl: LiveData<String> get() = _videosUrl

    fun setLessons(videosUrl: String) {
        _videosUrl.value = videosUrl
    }
}