package com.multiform.nyarticlesexample.models

import android.view.View
import com.multiform.nyarticlesexample.R
import com.multiform.nyarticlesexample.databinding.ItemArticleBinding
import com.xwray.groupie.viewbinding.BindableItem

data class Article(

    // Article title
    val title: String?,

    val link: String?,

    // Description
    val subtitle: String?,

    // Categories
    val categories: List<String>?,

    val datePublished: String?,

    val byAuthor: String?,

    val imageUrl: String?

)



//    : BindableItem<ItemArticleBinding>() {
//
//    override fun bind(viewBinding: ItemArticleBinding, position: Int) {
//        with(viewBinding) {
//            titleArticle.text = title
//            linkArticle.text = link
//            subtitleArticle.text = subtitle
//            categoriesArticle.text = categories?.joinToString("\n", "#")
//            dateArticle.text = datePublished?.split("-")?.reversed()?.joinToString("-")
//            authorArticle.text = byAuthor
//        }
//    }
//
//    override fun getLayout(): Int = R.layout.item_article
//
//    override fun initializeViewBinding(view: View): ItemArticleBinding =
//        ItemArticleBinding.bind(view)
//}
