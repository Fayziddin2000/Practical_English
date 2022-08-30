package com.boriyevfayz.practical_english.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.boriyevfayz.practical_english.Quizzes
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val mBinding get() = _binding


    var quizList = arrayListOf<Quizzes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        readFromAssets()
    }

    private fun readFromAssets() {
        val strings = arrayListOf<String>()
        val bufferedReader =
            BufferedReader(
                InputStreamReader(this.assets.open("test.txt"), "UTF-8")
            )
        try {

            strings.addAll(bufferedReader.readLines())
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                bufferedReader.close()
            } catch (e: IOException) {
            }
        }
        if (strings.isNotEmpty())
            createQuestions(strings)
    }

    private fun createQuestions(strings: ArrayList<String>) {
        for (str in strings) {
            when (str[0]) {
                '?' -> {
                    quizList.add(Quizzes(question = str.substring(1)))
                }
                '+' -> {
                    quizList.last().rightAnswer = str.substring(1)
                }
                '-' -> {
                    quizList.last().wrongAnswers.add(str.substring(1))
                }
            }
        }
    }

}


