package org.mz.mzbi.ui.screen

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Border
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest


import org.mz.mzbi.R

class UpVideoCard {
    @Composable
    fun Cards(vd:String) {
//        val okHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain -> //前置处理
//            val request=chain.request().newBuilder()
//                .build()
//            val response=chain.proceed(request)
//            //后置处理
//            response
//        }).build()
//        val imageLoader = ImageLoader.Builder(LocalContext.current)
//            .diskCachePolicy(CachePolicy.ENABLED)  //磁盘缓策略 ENABLED、READ_ONLY、WRITE_ONLY、DISABLED
//            .crossfade(true) //淡入淡出
//            .okHttpClient {  //设置okhttpClient实例
//                okHttpClient
//            }.build()
//
//        Coil.setImageLoader(imageLoader)
        Column {
            Card(
                onClick = {},
                Modifier
                    .widthIn(150.dp,500.dp)
                    .heightIn(200.dp,210.dp),
                scale =
                CardDefaults.scale(
                    focusedScale = 1.02f,
                ),
                border =
                CardDefaults.border(
                    Border(
                        border = BorderStroke(width = 1.dp, color = Color.White),
                        shape = RoundedCornerShape(3),
                    ),
                    focusedBorder = Border(
                        border = BorderStroke(width = 1.dp, color = Color.White),
                        shape = RoundedCornerShape(3),
                    ),
                    pressedBorder = Border(
                        border = BorderStroke(width = 1.dp, color = Color.White),
                        shape = RoundedCornerShape(3),
                    )
                ),
            ) {
                Column {
                    Box(Modifier.align(Alignment.Start)) {
                        AsyncImage(

                            modifier = Modifier
                                .height(145.dp).widthIn(220.dp,500.dp)
                                .paddingFromBaseline(0.dp, 2.dp),

                            model = ImageRequest.Builder(LocalContext.current)
                                .data(vd).addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36 Edg/130.0.0.0").addHeader("Referer","https://www.bilibili.com/").build()

//                                    add("Accept","image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8").
//                        add().add("user-agent","").add("sec-fetch-dest","image")
//                            .add(":method","GET").add(":scheme","https")
                           // .build()).bu
                                ,

                            error = painterResource(R.drawable.ic_broken_image),
                            placeholder = painterResource(R.drawable.loading_img),
                            onSuccess = {
                                Log.d(TAG, "success")
                            },
                            onError = {
                                Log.d(TAG, "Error")
                            }, onLoading = {
                                Log.d(TAG, "loadding")
                            },
                            contentDescription = null,
                        )


                        Row (Modifier.fillMaxWidth().fillMaxHeight(0.62f),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
                            Row() {
                                Image(
                                    modifier = Modifier.offset(5.dp, (-10).dp).padding(),
                                    painter = painterResource(id = R.drawable.plcount1),
                                    contentDescription = stringResource(R.string.hello_blank_fragment)
                                )
                                Text(
                                    text = "20万",
                                    modifier = Modifier.offset(5.dp, (-10).dp)
                                        .align(Alignment.CenterVertically).align(Alignment.Bottom),
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 12.sp
                                )
                                Image(
                                    modifier = Modifier.offset(10.dp, (-10).dp).padding(),
                                    painter = painterResource(id = R.drawable.dmcount),
                                    contentDescription = stringResource(R.string.hello_blank_fragment)
                                )
                                Text(
                                    text = "6000万",
                                    modifier = Modifier.offset(10.dp, (-10).dp)
                                        .align(Alignment.CenterVertically).align(Alignment.Bottom),
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 12.sp
                                )


                            }
                            Row(horizontalArrangement = Arrangement.End) {
                                Text(
                                    text = "12:30",
                                    modifier = Modifier.offset((-3).dp, (-12).dp).align(Alignment.CenterVertically),
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 12.sp
                                )
                            }
                        }


                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp,0.dp).offset(0.dp, (-10).dp),
                        text = "和敬公主：乾隆宠女儿，会有多疯狂？【乾隆往事】",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis

                    )
                    Row (Modifier.fillMaxWidth().padding(5.dp,3.dp),horizontalArrangement = Arrangement.SpaceBetween){
                        Row() {
                            Image(
                                modifier = Modifier.width(20.dp).align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.up_32),
                                contentDescription = stringResource(R.string.hello_blank_fragment)
                            )
                            Text(
                                text = "正在吃的舒服的",
                                Modifier.align(Alignment.CenterVertically).offset(0.dp, (-1).dp),
                                fontWeight = FontWeight.Thin,
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Row(horizontalArrangement = Arrangement.End) {
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = "3天前",
                                fontWeight = FontWeight.Thin,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }

}