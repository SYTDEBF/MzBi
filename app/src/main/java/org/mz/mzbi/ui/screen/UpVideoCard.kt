package org.mz.mzbi.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import org.mz.mzbi.R

class UpVideoCard {
    @Composable
    @Preview(showBackground = true)
    fun Cards() {
        Column {
            Card(
                onClick = {},
                Modifier
                    .widthIn(150.dp,500.dp)
                    .height(220.dp),
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
                                .height(145.dp)
                                .paddingFromBaseline(0.dp, 2.dp),

                            model = "https://i0.hdslb.com/bfs/archive/a9430cf6ec95303863801495b442e7e98a7b38b2.jpg@672w_378h_1c_!web-home-common-cover.avif",
                            contentDescription = null,
                        )
                        Row (Modifier.align(Alignment.BottomStart)) {
                            Image(
                            modifier = Modifier.offset(5.dp,(-10).dp).padding(),
                            painter = painterResource(id = R.drawable.plcount1),
                            contentDescription = stringResource(R.string.hello_blank_fragment)
                        )
                            Text(
                                text = "200万",
                                modifier = Modifier.offset(5.dp,(-10).dp).padding(),
                                color = Color.White,
                                maxLines = 1,
                                fontSize = 12.sp
                            )

                        }


                    }
                    Text(
                        modifier = Modifier
                            .width(254.dp)
                            .padding(5.dp,0.dp),
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
                                modifier = Modifier.width(20.dp),
                                painter = painterResource(id = R.drawable.up_32),
                                contentDescription = stringResource(R.string.hello_blank_fragment)
                            )
                            Text(
                                text = "正在吃的舒服的",

                                fontWeight = FontWeight.Thin,
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Row(horizontalArrangement = Arrangement.End) {
                            Text(
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