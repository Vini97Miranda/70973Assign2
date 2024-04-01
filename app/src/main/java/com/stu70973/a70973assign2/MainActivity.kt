package com.stu70973.a70973assign2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stu70973.a70973assign2.ui.theme._70973Assign2Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _70973Assign2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    //MovieHome()
                    //MovieScreen(DataProvider.movieList[0])
                    AndroidNavigation()
                }
            }
        }
    }
}

@Composable
fun MovieHome(navController: NavController) {
    val movies = remember { MovieInfo.movieList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier
        .background(Color.Black)

    ) {
        this.items(
            items = movies,
            itemContent = {
                MovieListItem(movie = it, navController)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidNavigation()
}
