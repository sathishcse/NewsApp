package com.example.newsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.models.NewsData
import javax.inject.Inject

class NewsAdapter @Inject constructor(private val onItemClick:(position:Int)->Unit)  : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<NewsData>() {
        override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem == newItem
        }

    }

    private val asyncListDiff = AsyncListDiffer(this,diffUtil)

    fun saveData(response:List<NewsData>){
        asyncListDiff.submitList(response)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            onItemClick,
        )
    }

    override fun getItemCount(): Int {
        return asyncListDiff.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(asyncListDiff.currentList[position])
    }

    inner class NewsViewHolder(
        val binding: ItemNewsBinding,
        private val onItemClicked:(pos:Int)->Unit)
        : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
            init {
                binding.root.setOnClickListener(this)
            }
        fun bind(art:NewsData){
            binding.title.text = art.title
        }

        override fun onClick(v: View?) {
            onItemClicked(adapterPosition)
        }
    }
}