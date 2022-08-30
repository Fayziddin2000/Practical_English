package com.boriyevfayz.practical_english

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter internal constructor(private val youtubeVideoList: List<youTubeVideos>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)


    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.videoWeb.loadData(youtubeVideoList[position].videoUrl!!, "text/html", "utf-8")

    }

    @SuppressLint("SetJavaScriptEnabled")
    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var videoWeb: WebView = itemView.findViewById(R.id.videoWeb)

        init {
            videoWeb.webChromeClient = object : WebChromeClient() {
            }
            videoWeb.settings.javaScriptEnabled = true

        }

    }

    override fun getItemCount(): Int {
        return youtubeVideoList.size
    }
}