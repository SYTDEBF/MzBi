package org.mz.mzbi

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.mz.mzbi.ui.screen.HomePage
import org.mz.mzbi.ui.screen.PartitionsPage

import kotlin.time.Duration.Companion.microseconds

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent {
            var selectedIndex by remember { mutableIntStateOf(0) }

            val items =
                listOf(
                    "主页" to Icons.Default.Home,
                    "分区" to Icons.Default.Settings,
                    "Favourites" to Icons.Default.Favorite,
                )
            val navController = rememberNavController()
            NavigationDrawer(
                drawerContent = {
                    Column(
                        Modifier
                            .background(Color(30, 32, 34))
                            .fillMaxHeight()
                            .padding(12.dp)
                            .selectableGroup(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items.forEachIndexed { index, item ->
                            val (text, icon) = item

                            NavigationDrawerItem(
                                selected = selectedIndex == index,

                                onClick = {
                                    selectedIndex = index
                                    when(selectedIndex){

                                        0 -> navController.navigate("HomePage")
                                        1 -> navController.navigate("PartitionsPage")
                                    }
                                },
                                leadingContent = {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null,
                                    )
                                }
                            ) {
                                Text(text)
                            }
                        }
                    }

                },
                content = {

                    NavHost(navController = navController, startDestination = "HomePage") {
                        //声明名为MainPage的页面路由
                        composable("HomePage") {
                            //页面路由对应的页面组件
                            Log.d("HomePage","HomePage")
                            HomePage().TabList()
                        }
                        composable("PartitionsPage") {
                            Log.d("PartitionsPage","PartitionsPage")
                            PartitionsPage().TabList()
                        }
                    }


                }
            )


//            {
//                Button(modifier = Modifier.height(10.dp).width(20.dp), onClick = {}) { Text("BUTTON")
//                }
//            }
        }
    }
}





