package org.mz.mzbi.ui.screen

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
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.microseconds

class PartitionsPage {
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    @Preview(showBackground = true)
    fun TabList() {
        val tabs = listOf("音乐", "动漫", "电影")
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val navController = rememberNavController()

// This index will be used to show a panel
        var tabPanelIndex by remember { mutableIntStateOf(selectedTabIndex) }

// Change the tab-panel only after some delay
        LaunchedEffect(selectedTabIndex) {
            delay(250.microseconds)
            tabPanelIndex = selectedTabIndex
        }

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
//                            if (selectedTabIndex==1)
//                                navController.navigate("SettingPage")
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
    }
}
