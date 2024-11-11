package org.mz.mzbi.ui.screen


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.mz.mzbi.tools.HttpStrRep
import org.mz.mzbi.ui.vm.UpCardViewModel


class ReComPage {
    @Composable
    @Preview
    fun UpVideoCardList() {
        val tabs = listOf("推荐", "热门", "Tab 3")
        val viewModel: UpCardViewModel = viewModel()
        //viewModel.getUpVideoCardData("on")
        val upVideoCardDataListResult = viewModel.upVideoCardLiveData.observeAsState().value

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {


            val cardList = upVideoCardDataListResult?.getOrNull()
            if (cardList != null) {
                for (i in cardList.indices) {
                    items(1) {
                        UpVideoCard().Cards(
                            HttpStrRep.greet(cardList[i].pic + "@672w_378h_1c_!web-home-common-cover.jpg"),cardList[i].title
                        )
                    }
                }
            }


        }

    }


}


