package com.example.home.presentation.home

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.featureHome.R
import com.example.home.domain.model.FeedArticleDomainModel
import com.igorwojda.showcase.library.base.delegate.observer

internal class ArticleListAdapter(layoutResId: Int, data: List<FeedArticleDomainModel>) :
    BaseQuickAdapter<FeedArticleDomainModel, BaseViewHolder>(layoutResId) {

    var feedArticles: List<FeedArticleDomainModel> by observer(listOf(), {
        setNewData(it)
    })
    private var isCollectPage = false
    private var isSearchPage = false
    private var isNightMode = false

    fun isCollectPage() {
        isCollectPage = true
        notifyDataSetChanged()
    }

    fun isSearchPage() {
        isSearchPage = true
        notifyDataSetChanged()
    }

    fun isNightMode(isNightMode: Boolean) {
        this.isNightMode = isNightMode
        notifyDataSetChanged()
    }

    override fun convert(helper: BaseViewHolder, item: FeedArticleDomainModel) {
        item.run {
            helper.setText(R.id.item_search_pager_title, titleHtml)

            if (collect && isCollectPage) {
                helper.setImageResource(
                    com.example.featureHome.R.id.item_search_pager_like_iv,
                    com.example.featureHome.R.drawable.icon_like
                )
            } else {
                helper.setImageResource(
                    com.example.featureHome.R.id.item_search_pager_like_iv,
                    R.drawable.icon_like_article_not_selected
                )
            }

            if (author.isNotEmpty()) {
                helper.setText(com.example.featureHome.R.id.item_search_pager_author, author)
            }
            setTag(helper, item)
            if (chapterName.isNotEmpty()) {
                val classifyName = "$superChapterName / $chapterName"
                helper.setText(
                    com.example.featureHome.R.id.item_search_pager_chapterName,
                    if (isCollectPage) chapterName else classifyName
                )
            }
            if (niceDate.isNotEmpty()) {
                helper.setText(com.example.featureHome.R.id.item_search_pager_niceDate, niceDate)
            }
            if (isSearchPage) {
                val cardView: CardView =
                    helper.getView(com.example.featureHome.R.id.item_search_pager_group)
                cardView.foreground = null
                if (isNightMode) {
                    cardView.background = ContextCompat.getDrawable(
                        mContext,
                        com.example.featureHome.R.color.card_color
                    )
                } else {
                    cardView.background = ContextCompat.getDrawable(
                        mContext,
                        com.example.featureHome.R.drawable.selector_search_item_bac
                    )
                }
            }
        }
    }

    private fun setTag(helper: BaseViewHolder, item: FeedArticleDomainModel) {
        helper.setGone(com.example.featureHome.R.id.item_search_pager_tag_green_tv, false)
            .setGone(com.example.featureHome.R.id.item_search_pager_tag_red_tv, false)
        if (isCollectPage) {
            return
        }
        item.run {
            if (superChapterName.contains(mContext.getString(com.example.featureHome.R.string.open_project))) {
                setRedTag(helper, com.example.featureHome.R.string.open_project)
            }
            if (superChapterName.contains(mContext.getString(com.example.featureHome.R.string.navigation))) {
                setRedTag(helper, com.example.featureHome.R.string.navigation)
            }

            if (niceDate.contains(mContext.getString(com.example.featureHome.R.string.minute)) || niceDate.contains(
                    mContext.getString(R.string.hour)
                ) || niceDate.contains(mContext.getString(R.string.one_day))
            ) {
                helper.getView<TextView>(R.id.item_search_pager_tag_green_tv).visibility =
                    View.VISIBLE
                helper.setText(R.id.item_search_pager_tag_green_tv, R.string.text_new)
                helper.setTextColor(
                    R.id.item_search_pager_tag_green_tv,
                    ContextCompat.getColor(mContext, R.color.light_green)
                )
                helper.setBackgroundRes(
                    R.id.item_search_pager_tag_green_tv,
                    R.drawable.shape_tag_green_background
                )
            }
        }
    }

    private fun setRedTag(helper: BaseViewHolder, tagName: Int) {
        helper.getView<TextView>(R.id.item_search_pager_tag_red_tv).visibility = View.VISIBLE
        helper.setText(R.id.item_search_pager_tag_red_tv, tagName)
        helper.setTextColor(
            R.id.item_search_pager_tag_red_tv,
            ContextCompat.getColor(mContext, R.color.light_deep_red)
        )
        helper.setBackgroundRes(
            R.id.item_search_pager_tag_red_tv,
            R.drawable.selector_tag_red_background
        )
    }
}