package com.stu70973.a70973assign2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
private fun MovieImage(movie: dataType) {
    Image(
        painter = painterResource(id = movie.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
fun MovieListItem(movie: dataType, navController: NavController, modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Routers.SecondScreen.route + "/" + movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            MovieImage(movie)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center) {

                Text(text = movie.name, style = typography.titleMedium)
                if(movie.seats_selected > 0)
                {
                    Text(text = movie.seats_selected.toString() + " seats selected",
                        style = typography.bodyMedium,
                        color = Color.Green
                    )
                }
                else {
                    Text(
                        text = movie.seats_remaining.toString() + " seats remaining ",
                        style = typography.bodyMedium,
                        color = Color.Red
                    )
                }
            }
        }
    }
}