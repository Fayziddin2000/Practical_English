package com.boriyevfayz.practical_english.ui

import android.os.Bundle
import android.system.Os.close
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.boriyevfayz.practical_english.LessonAdapter
import com.boriyevfayz.practical_english.Lessons
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.databinding.FragmentLessonsBinding

class LessonsFragment() : Fragment(), LessonAdapter.OnItemClickListener {
    private lateinit var _binding: FragmentLessonsBinding
    private val mBinding get() = _binding
    private val lessonList = arrayOf(
        "+++Lesson 1.pdf",
        "+++Lesson 2.pdf",
        "+++Lesson 3.pdf",
        "+++Lesson 4.pdf",
        "+++Lesson 5.pdf",
        "+++Lesson 6.pdf",
        "+++Lesson 7.pdf",
        "+++Lesson 8.pdf",
        "+++Lesson 9.pdf",
        "+++Lesson 10.pdf",
        "+++Lesson 11.pdf",
        "+++Lesson 12.pdf",
        "+++Lesson 13.pdf",
        "+++Lesson 14.pdf",
        "+++Lesson 15.pdf",
        "+++Lesson 16.pdf",
        "+++Lesson 17.pdf",
        "+++Lesson 18.pdf",
        "+++Lesson 19.pdf",
        "+++Lesson 20.pdf",
        "+++Lesson 21.pdf",
        "+++Lesson 22.pdf",
        "+++Lesson 23.pdf",
        "+++Lesson 24.pdf",
    )

    private val lessonTitle = arrayListOf<Lessons>()
    private lateinit var adapter: LessonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonsBinding.inflate(layoutInflater, container, false)

        mBinding.tvTitleSec.text = "Lessons"
        mBinding.ivBackSec.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, HomeFragment()).commit()
        }
        setName()
        return mBinding.root
    }


    private fun setName() {
        lessonTitle.add(Lessons("Lesson 1"))
        lessonTitle.add(Lessons("Lesson 2"))
        lessonTitle.add(Lessons("Lesson 3"))
        lessonTitle.add(Lessons("Lesson 4"))
        lessonTitle.add(Lessons("Lesson 5"))
        lessonTitle.add(Lessons("Lesson 6"))
        lessonTitle.add(Lessons("Lesson 7"))
        lessonTitle.add(Lessons("Lesson 8"))
        lessonTitle.add(Lessons("Lesson 9"))
        lessonTitle.add(Lessons("Lesson 10"))
        lessonTitle.add(Lessons("Lesson 11"))
        lessonTitle.add(Lessons("Lesson 12"))
        lessonTitle.add(Lessons("Lesson 13"))
        lessonTitle.add(Lessons("Lesson 14"))
        lessonTitle.add(Lessons("Lesson 15"))
        lessonTitle.add(Lessons("Lesson 16"))
        lessonTitle.add(Lessons("Lesson 17"))
        lessonTitle.add(Lessons("Lesson 18"))
        lessonTitle.add(Lessons("Lesson 19"))
        lessonTitle.add(Lessons("Lesson 20"))
        lessonTitle.add(Lessons("Lesson 21"))
        lessonTitle.add(Lessons("Lesson 22"))
        lessonTitle.add(Lessons("Lesson 23"))
        lessonTitle.add(Lessons("Lesson 24"))
        adapter = LessonAdapter(lessonTitle, this)
        mBinding.rvSecondfrag.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvSecondfrag.adapter = adapter
    }


    override fun onClick(item: Lessons, position: Int) {
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.main_container,
                LessonFragment(lessonList[position], lessonTitle[position])
            ).commit()
        lessonTitle.clear()
    }


}