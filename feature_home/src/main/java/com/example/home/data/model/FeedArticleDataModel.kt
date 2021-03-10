package com.example.home.data.model

import android.text.Html
import com.example.home.domain.model.FeedArticleDomainModel

internal data class FeedArticleDataModel (
        var apkLink:String,
        var author:String,
        var chapterName:String,
        var desc:String,
        var envelopePic:String,
        var link:String,
        var niceDate:String,
        var origin:String,
        var projectLink:String,
        var superChapterName:String,
        var title:String,
        var chapterId : Int,
        var courseId : Int,
        var id : Int,
        var superChapterId : Int,
        var visible : Int,
        var zan : Int,
        val publishTime : Long,
        val collect : Boolean
)

internal fun FeedArticleDataModel.toDomainModel() : FeedArticleDomainModel{
    return FeedArticleDomainModel(
            this.apkLink,
            this.author,
            this.chapterName,
            this.desc,
            this.envelopePic,
            this.link,
            this.niceDate,
            this.superChapterName,
            this.title,
            Html.fromHtml(this.title).toString(),
            this.chapterId,
            this.id,
            this.visible,
            this.collect
    )
}