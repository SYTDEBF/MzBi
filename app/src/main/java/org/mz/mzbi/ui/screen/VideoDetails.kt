package org.mz.mzbi.ui.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.OutlinedIconButton
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.mz.mzbi.R
import org.mz.mzbi.tools.VideoDataConvert


@Composable
private fun MovieImageWithGradients(
//        movieDetails: MovieDetails,
    modifier: Modifier = Modifier,
    gradientColor: Color = MaterialTheme.colorScheme.background,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://i2.hdslb.com/bfs/archive/c5e2a31f6d7f2e9c8f1c1ea7e227ef5e18766065.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            .crossfade(true).build(),
        contentDescription = "as",
        contentScale = ContentScale.Crop,

        modifier = modifier.drawWithContent {
            drawContent()
            drawRect(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0.0f, 0.0f, 0.0f, 0.882f)),
                    startY = 600f
                )
            )
            drawRect(
                Brush.horizontalGradient(
                    colors = listOf(Color(0.0f, 0.0f, 0.0f, 0.882f), Color.Transparent),
                    endX = 800f,
                    startX = 500f
                )
            )
            drawRect(
                Brush.linearGradient(

                    colors = listOf(Color(0.0f, 0.0f, 0.0f, 0.863f), Color.Transparent),
                    start = Offset(x = 1000f, y = 500f),
                    end = Offset(x = 1000f, y = 0f)
                )
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun MovieImageWithGradients1(
//        movieDetails: MovieDetails,
) {
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    Log.d("纯爷们","Sds")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .bringIntoViewRequester(bringIntoViewRequester)

    ) {
        MovieImageWithGradients(
            modifier = Modifier.fillMaxSize()
        )
//
        Column(modifier = Modifier.fillMaxWidth(0.55f)) {
            Spacer(modifier = Modifier.height(70.dp))
            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                VideoLargeTitle("三权合一！特朗普成为美国40年以来权力最大的总统！将势不可挡")
                Column(
                    modifier = Modifier.alpha(0.75f)
                ) {
                    VideoBrief("三权合一！特朗普成为美国40年以来权力最大的总统！势不可挡！")
                    Row (){
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.plcount1),
                            contentDescription = stringResource(R.string.hello_blank_fragment)
                        )
                        Text(
                            text = VideoDataConvert.conToTenThousand(9999999),
                            modifier = Modifier.align(Alignment.CenterVertically),
                            fontFamily = FontFamily.Default,
                            color = Color.White,
                            lineHeight = 20.sp,
                            maxLines = 1,
                            fontSize = 14.sp
                        )
                    }
                    OutlinedButton(onClick = {}) {
                        Icon(Icons.Outlined.PlayArrow, contentDescription = "Localized description")
                        Spacer(Modifier.size(8.dp))
                        Text(text="Outlined Button") }
                    OutlinedIconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Outlined.PlayArrow, contentDescription = "Localized description")
                        Text("Outlined Button")
                    }
                }
            }

        }
        Column { Text(text = "sdsdd", color = Color.White) }
    }
}

/**
 * 视频标题
 */
@Composable
private fun VideoLargeTitle(videoTitle: String) {
    Text(
        text = videoTitle,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        maxLines = 5
    )
}

/**
 * 视频简介
 */
@Composable
private fun VideoBrief(videoBrief: String) {
    Text(
        text = videoBrief,
        color = Color.White,
        //fontWeight = FontWeight,
        fontSize = 16.sp,
        maxLines = 5
    )
}



