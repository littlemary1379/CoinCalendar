package com.example.coincalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coincalendar.extension.formatString
import com.example.coincalendar.ui.theme.CoinCalendarTheme
import java.util.Date

class MainActivity : ComponentActivity() {

    var pageCount = Int.MAX_VALUE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinCalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calender()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calender() {

    var pagerState = rememberPagerState(
        pageCount = { Int.MAX_VALUE },
        initialPage = Int.MAX_VALUE / 2 )
    HorizontalPager(state = pagerState) { page ->

        Column {
            // 날짜 표기 row start
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_left_arrow),
                        contentDescription = "left arrow",
                        modifier = Modifier.clickable {
                            println("left arrow click")
                        }.width(30.dp).height(30.dp)
                    )
                }

                Text(
                    text = Date().formatString("yyyy년 MM월"),
                    fontSize = 20.sp
                )

                Box(
                    modifier = Modifier.padding(start = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_right_arrow),
                        contentDescription = "right arrow",
                        modifier = Modifier.clickable {
                            println("right arrow click")
                        }.width(30.dp).height(30.dp)
                    )
                }
            }
            // 날짜 표기 row end



            Text(
                text = "Page : $page",
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoinCalendarTheme {
        Calender()
    }
}