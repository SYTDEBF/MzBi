package org.mz.mzbi.logic.model

data class UpVideoCardDataRes(val code: Int, val data: Data)

data class Data(val item:List<UpVideoCardData>)
data class UpVideoCardData(
    val bvid: String, val uri: String, val pic: String,
    val title: String, val duration: Int, val pubdate: Int, val owner: Owner,
    val stat: Stat
)

data class Stat(val view:Int,val danmaku:Int)

data class Owner(val name:String)

