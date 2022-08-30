package com.boriyevfayz.practical_english

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boriyevfayz.practical_english.databinding.ItemLessonsBinding

class LessonAdapter(
    private val lessonList: ArrayList<Lessons>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<LessonAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemLessonsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(lessonList[position])
        holder.itemView.setOnClickListener {
            listener.onClick(lessonList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    interface OnItemClickListener {
        fun onClick(item: Lessons, position: Int)
    }

    class VH(private val mBinding: ItemLessonsBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: Lessons) {
            mBinding.tvLessonNumb.text = item.name
        }

    }

}