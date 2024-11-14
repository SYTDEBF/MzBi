package org.mz.mzbi.ui.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text
import kotlinx.coroutines.delay
import org.mz.mzbi.ui.vm.UpCardViewModel
import kotlin.time.Duration.Companion.microseconds

class HomePage {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    @Preview(showBackground = true)
    fun TabList() {
        val tabs = listOf("推荐", "热门", "Tab 3")
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val navController = rememberNavController()

// This index will be used to show a panel
        var tabPanelIndex by remember { mutableIntStateOf(selectedTabIndex) }


// Change the tab-panel only after some delay
        LaunchedEffect(selectedTabIndex) {
            delay(250.microseconds)
            tabPanelIndex = selectedTabIndex
        }
        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .focusRestorer()
                    .paddingFromBaseline(20.dp)
                    .padding(20.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            {
                tabs.forEachIndexed { index, tab ->
                    key(index) {
                        Tab(
                            selected = index == selectedTabIndex,
                            onFocus = { selectedTabIndex = index },
                            onClick = {
                                selectedTabIndex = index
                                if (selectedTabIndex == 0){
                                    navController.navigate("ReComPage")
                                }





                            },
                            content = {

                                Text(
                                    text = tab,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 6.dp
                                    )
                                )

                            }
                        )
                    }
                }
            }

            NavHost(navController = navController, startDestination = "ReComPage") {
                //声明名为MainPage的页面路由
                composable("ReComPage") {
                    //页面路由对应的页面组件
                    Log.d("跳转2","dsd")
                    val s:UpCardViewModel = UpCardViewModel()

                    ReComPage().UpVideoCardList(viewModel = s)
                }
            }
        }

    }
}