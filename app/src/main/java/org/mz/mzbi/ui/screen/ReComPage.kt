package org.mz.mzbi.ui.screen


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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
            items(10) {
                UpVideoCard().Cards()
            }
        }

    }
}

