package com.example.home.domain.model

data class FeedArticleDomainModel(
        var apkLink: String,
        var author: String,
        var chapterName: String,
        var desc: String,
        var envelopePic: String,
        var link: String,
        var niceDate: String,
        var superChapterName: String,
        var title: String,
        var titleHtml: String,
        var chapterId: Int,
        var id: Int,
        var visible: Int,
        val collect: Boolean
)