package com.boriyevfayz.practical_english

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel:ViewModel() {
    private val _timer: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val timer: LiveData<Boolean> get() = _timer

    fun startTimer() {
        Handler().postDelayed({
            _timer.postValue(true)
        }, 3000)
    }
}