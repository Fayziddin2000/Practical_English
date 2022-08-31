package com.boriyevfayz.practical_english.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.boriyevfayz.practical_english.LessonViewModel
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val mBinding get() = _binding

    private lateinit var viewModel: LessonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[LessonViewModel::class.java]

        mBinding.cvLessons.setOnClickListener {
            viewModel.setLessonsPage(1)
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_container, LessonsFragment()).commit()
        }

        mBinding.cvVideos.setOnClickListener {
            viewModel.setLessonsPage(2)
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_container, LessonsFragment()).commit()
        }

        mBinding.cvQuizes.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, QuizzesFragment()).commit()
        }
    }
}