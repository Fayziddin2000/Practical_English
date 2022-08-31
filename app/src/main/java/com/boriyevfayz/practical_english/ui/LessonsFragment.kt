package com.boriyevfayz.practical_english.ui

import android.os.Bundle
import android.system.Os.close
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.boriyevfayz.practical_english.*
import com.boriyevfayz.practical_english.databinding.FragmentLessonsBinding
import kotlin.properties.Delegates

class LessonsFragment() : Fragment(), LessonAdapter.OnItemClickListener {
    private lateinit var _binding: FragmentLessonsBinding
    private val mBinding get() = _binding

    private lateinit var viewModel: LessonViewModel
    private lateinit var urlViewModel: VideosUrlViewModel

    private var page: Int? = null


    private val videosUrl = arrayOf(
        "https://www.youtube.com/embed/JL3jYAPVvqQ",
        "https://www.youtube.com/embed/O3g7uVzc4qk",
        "https://www.youtube.com/embed/hekufagJ-jQ",
        "https://www.youtube.com/embed/wfkj1Q6VTDg",
        "https://www.youtube.com/embed/GJeKcIj__rg",
        "https://www.youtube.com/embed/6j72uKkCBKo",
        "https://www.youtube.com/embed/D5tNAVR1Jog",
        "https://www.youtube.com/embed/o2qyCegdKlQ",
        "https://www.youtube.com/embed/XHn-doz9Rn8",
        "https://www.youtube.com/embed/P1mmrZ3pBkY",
        "https://www.youtube.com/embed/SJgeI80Oebg",
        "https://www.youtube.com/embed/n6tcfkATbrY",
        "https://www.youtube.com/embed/uLxsO_TDN18",
        "https://www.youtube.com/embed/pwcc1_CVir4",
        "https://www.youtube.com/embed/C3F9Pk361F8",
        "https://www.youtube.com/embed/biH7j-SQ3Ac",
        "https://www.youtube.com/embed/LtMgMxl44j8",
        "https://www.youtube.com/embed/ecN0ev3AgrM",
        "https://www.youtube.com/embed/V9onTncNsZY",
        "https://www.youtube.com/embed/SnjABk61MvI",
        "https://www.youtube.com/embed/IB8MIzUKI6A",
        "https://www.youtube.com/embed/TbNAWG2ukyQ",
        "https://www.youtube.com/embed/mzN7SVWbK0E",
        "https://www.youtube.com/embed/ZF5vKgEx_NI",

        )

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

        viewModel = ViewModelProvider(requireActivity())[LessonViewModel::class.java]
        urlViewModel = ViewModelProvider(requireActivity())[VideosUrlViewModel::class.java]

        viewModel.mLessonPage.observe(viewLifecycleOwner) { lessonPage ->
            page = lessonPage
        }

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
        when (page) {
            1 -> {
                viewModel.setLessons(lessonList[position], lessonTitle[position].name)
                requireActivity().supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(
                        R.id.main_container,
                        LessonFragment()
                    ).commit()
                lessonTitle.clear()
            }
            2 -> {
                urlViewModel.setLessons(videosUrl[position])
                requireActivity().supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(
                        R.id.main_container,
                        VideoFragment()
                    ).commit()
                lessonTitle.clear()

            }
        }


    }
}