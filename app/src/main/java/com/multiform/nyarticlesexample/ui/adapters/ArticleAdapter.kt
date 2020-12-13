package com.multiform.nyarticlesexample.ui.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.multiform.nyarticlesexample.R
import com.multiform.nyarticlesexample.databinding.ItemArticleBinding
import com.multiform.nyarticlesexample.models.Article
import com.multiform.nyarticlesexample.utils.APP_ACTIVITY
import com.multiform.nyarticlesexample.utils.showToast

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private val items = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            if (items[position].byAuthor.isNullOrEmpty()) {
                authorArticle.visibility = View.GONE
            }
            if (items[position].subtitle.isNullOrEmpty()) {
                subtitleArticle.visibility = View.GONE
            }

            titleArticle.text = items[position].title
            subtitleArticle.text = items[position].subtitle
            categoriesArticle.text = items[position].categories?.joinToString("\n#", "#")
            dateArticle.text = items[position].datePublished?.split("-")?.reversed()?.joinToString("-")
            authorArticle.text = items[position].byAuthor

            linkArticle.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(items[position].link))
                APP_ACTIVITY.startActivity(intent)
            }

            imageArticle.clipToOutline = true

            imageArticle.setOnClickListener {
                showToast("img")
            }

            Glide.with(APP_ACTIVITY)
                .load(items[position].imageUrl)
                .centerCrop()
                .placeholder(R.drawable.bg_progress)
                .into(imageArticle)

            // TODO загрузка картинок в фоне, анимированный placeholder
        }
    }

    fun addItems(newItems: List<Article>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root)
}