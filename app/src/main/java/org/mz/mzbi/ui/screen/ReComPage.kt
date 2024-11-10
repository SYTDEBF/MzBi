package org.mz.mzbi.ui.screen


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mz.mzbi.tools.HttpStrRep


class ReComPage {
    @Composable
    @Preview
    fun UpVideoCardList(){
        val tabs = listOf("推荐", "热门", "Tab 3")
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            items(1) {
                UpVideoCard().Cards(
                        "https://i2.hdslb.com/bfs/archive/8e8272b2773b7a5614b0ee4f4651dc863360a65a.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(
                        "https://i0.hdslb.com/bfs/archive/24cc1cc486fb653aa6a1edbc22a0b7077d60f094.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(
                        "https://i1.hdslb.com/bfs/archive/1e45ede6034e4d939e6e49e217c58aefb4fe8cad.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(
                        HttpStrRep.greet("http://i1.hdslb.com/bfs/archive/1e45ede6034e4d939e6e49e217c58aefb4fe8cad.jpg@672w_378h_1c_!web-home-common-cover.jpg"))
            }
            items(1) {
                UpVideoCard().Cards(
                        "https://i0.hdslb.com/bfs/archive/09645277a39bd12bb4c54294eb66d27bae8a0bfa.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(

                                "https://i1.hdslb.com/bfs/archive/9eb7c62e3ce3b7475cd97775dd98c31ebb61bd8c.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(

                    "https://i1.hdslb.com/bfs/archive/9eb7c62e3ce3b7475cd97775dd98c31ebb61bd8c.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
            items(1) {
                UpVideoCard().Cards(

                    "https://i1.hdslb.com/bfs/archive/9eb7c62e3ce3b7475cd97775dd98c31ebb61bd8c.jpg@672w_378h_1c_!web-home-common-cover.jpg")
            }
        }

    }
}

