package com.multiform.nyarticlesexample.ui.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiform.nyarticlesexample.databinding.ProgressArticleBinding

class ProgressAdapter: RecyclerView.Adapter<ProgressAdapter.ViewHolder>() {

    private val list = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProgressArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(holder.binding) {
//            titleProgress.setBackgroundResource(list[position])
//            imageProgress.setBackgroundResource(list[position])
//        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: ProgressArticleBinding): RecyclerView.ViewHolder(binding.root)
}