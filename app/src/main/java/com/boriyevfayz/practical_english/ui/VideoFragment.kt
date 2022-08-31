package com.boriyevfayz.practical_english.ui

import android.R
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.boriyevfayz.practical_english.VideosUrlViewModel
import com.boriyevfayz.practical_english.databinding.FragmentVideoBinding


class VideoFragment : Fragment() {

    private lateinit var _binding: FragmentVideoBinding
    private val mBinding get() = _binding

    private lateinit var viewModel: VideosUrlViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    @SuppressLint("SetJavaScriptEnabled")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[VideosUrlViewModel::class.java]
        viewModel.mVideosUrl.observe(viewLifecycleOwner) { videoUrl ->
            mBinding.videoWeb.loadData(
                "<iframe width=\"100%\" height=\"100%\" src=\"$videoUrl\" frameborder=\"0\" allowfullscreen></iframe>",
                "text/html",
                "utf-8"
            )
        }

        mBinding.videoWeb.webChromeClient = object : WebChromeClient() {
        }
        mBinding.videoWeb.settings.javaScriptEnabled = true
        mBinding.videoWeb.webChromeClient = object : WebChromeClient() {
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)
                mBinding.clLessonMin.visibility = View.GONE
                mBinding.clLessonMax.visibility = View.VISIBLE
                mBinding.clLessonMax.addView(view)
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
                mBinding.clLessonMin.visibility = View.VISIBLE
                mBinding.clLessonMax.visibility = View.GONE

            }

        }
    }
}

