package com.boriyevfayz.practical_english.ui

import android.R
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boriyevfayz.practical_english.VideoAdapter
import com.boriyevfayz.practical_english.databinding.FragmentVideoBinding
import com.boriyevfayz.practical_english.youTubeVideos
import java.util.*


class VideoFragment : Fragment() {

    private lateinit var _binding: FragmentVideoBinding
    private val mBinding get() = _binding

    private lateinit var recyclerView: RecyclerView
    private var youtubeVideos = Vector<youTubeVideos>()


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

        mBinding.tvTitleSec.text = "Lessons videos"
        recyclerView = mBinding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JL3jYAPVvqQ\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/O3g7uVzc4qk\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/hekufagJ-jQ\" frameborder=\"0\" allowfullscreen>lt;/iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/wfkj1Q6VTDg\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/GJeKcIj__rg\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/6j72uKkCBKo\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/D5tNAVR1Jog\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/o2qyCegdKlQ\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/XHn-doz9Rn8\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/P1mmrZ3pBkY\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/SJgeI80Oebg\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/n6tcfkATbrY\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/uLxsO_TDN18\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/pwcc1_CVir4\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/C3F9Pk361F8\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/biH7j-SQ3Ac\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/LtMgMxl44j8\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/ecN0ev3AgrM\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/V9onTncNsZY\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/SnjABk61MvI\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/IB8MIzUKI6A\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/TbNAWG2ukyQ\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/mzN7SVWbK0E\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        youtubeVideos.add(
            youTubeVideos(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                        ".youtube.com/embed/ZF5vKgEx_NI\" frameborder=\"0\" allowfullscreen></iframe>"
            )
        )
        val videoAdapter = VideoAdapter(youtubeVideos)
        recyclerView.adapter = videoAdapter
    }


}

