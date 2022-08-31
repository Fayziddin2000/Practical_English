package com.boriyevfayz.practical_english.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.boriyevfayz.practical_english.LessonViewModel
import com.boriyevfayz.practical_english.Lessons
import com.boriyevfayz.practical_english.MainViewModel
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.databinding.FragmentLessonBinding

class LessonFragment : Fragment() {

    private lateinit var _binding: FragmentLessonBinding
    private val mBinding get() = _binding

    private lateinit var viewModel: LessonViewModel
    private var page: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[LessonViewModel::class.java]

        viewModel.mLessons.observe(viewLifecycleOwner) { lessons ->
            mBinding.pvInfo.fromAsset(lessons).show()
            mBinding.ivBackThird.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, LessonsFragment())
                    .commit()
            }
            mBinding.tvTitleThird.text = viewModel.mLessonTitle.value.toString()
            mBinding.fullscreen.setOnClickListener {
                mBinding.pvInfo2.fromAsset(lessons).show()
                mBinding.clLessonMin.visibility = View.GONE
                mBinding.clLessonMax.visibility = View.VISIBLE
            }
        }
    }
}