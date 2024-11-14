package org.mz.mzbi.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest




    @Composable
    private fun MovieImageWithGradients(
//        movieDetails: MovieDetails,
        modifier: Modifier = Modifier,
        gradientColor: Color = MaterialTheme.colorScheme.surface,
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data("https://i0.hdslb.com/bfs/archive/c4fb015fe8290cd22fa29745ba72474dd5a26fa3.jpg")
                .crossfade(true).build(),
            contentDescription ="as",
            contentScale = ContentScale.Crop,

            modifier = modifier.drawWithContent {
                drawContent()
                drawRect(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, gradientColor),
                        startY = 600f
                    )
                )
                drawRect(
                    Brush.horizontalGradient(
                        colors = listOf(gradientColor, Color.Transparent),
                        endX = 800f,
                        startX = 300f
                    )
                )
                drawRect(
                    Brush.linearGradient(
                        colors = listOf(gradientColor, Color.Transparent),
                        start = Offset(x = 500f, y = 500f),
                        end = Offset(x = 1000f, y = 0f)
                    )
                )
            }
        )
    }

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
private fun MovieImageWithGradients1(
//        movieDetails: MovieDetails,
) {
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(432.dp).bringIntoViewRequester(bringIntoViewRequester)

    ) {
        MovieImageWithGradients(
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.fillMaxSize().alpha(0.6f).background(Color.Black)
        ){

        }
        Column { Text(text = "sdsdd") }
    }
}



