package com.multiform.nyarticlesexample.ui

import androidx.fragment.app.Fragment
import com.multiform.nyarticlesexample.R
import com.multiform.nyarticlesexample.databinding.FragmentArticlesBinding
import com.multiform.nyarticlesexample.ui.adapters.ArticleAdapter
import com.multiform.nyarticlesexample.utils.viewBinding
import com.multiform.nyarticlesexample.utils.viewModel

class ArticlesFragment : Fragment(R.layout.fragment_articles) {

    private val binding by viewBinding { FragmentArticlesBinding.bind(it) }

    private val adapter = ArticleAdapter()

    override fun onResume() {
        super.onResume()

        with(binding) {
            recyclerView.hasFixedSize()
            recyclerView.adapter = adapter
        }

        viewModel.items.observe(this, {
            it ?: return@observe
            adapter.clear()
            adapter.addItems(it)
        })

        binding.recyclerView.scrollState
    }


}