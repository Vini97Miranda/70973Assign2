package com.stu70973.a70973assign2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Screens(movie: dataType, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Image(painter = painterResource(id = R.drawable.back),
            contentDescription = "A back arrow",
            modifier = Modifier
                .size(width = 20.dp, height = 20.dp)
                .clickable {
                    navController.navigate(Routers.FirstScreen.route)
                })
        Image(painter = painterResource(id = movie.imageId) ,
            contentDescription = "A movie cover",
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f),
            contentScale = ContentScale.Crop)
        Bottom(movie)
    }
}

fun conv(movie: dataType) :String
{
    var stares = "";
    for (i in movie.starring)
        stares +="$i, "
    stares.removeSuffix(", ")
    return stares
}
@Composable
fun Bottom(movie: dataType) {
    var seats_selected by remember { mutableStateOf(movie.seats_selected) }
    var seats_remaining by remember { mutableStateOf(movie.seats_remaining) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = movie.name,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(id = movie.certification),
                contentDescription = "A seat",
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Text(
                text = "Staring ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = conv(movie),
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Text(
                text = "Running time ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = (movie.running_time_mins / 60).toString() + "hr " + (movie.running_time_mins % 60).toString() + "mins",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = movie.description,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.CenterVertically,
            //modifier = Modifier
                //.padding(15.dp)

        ) {
            Text(
                text = "Select Seats",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.width(5.dp))
            Image(painter = painterResource(id = if (seats_selected == 0) R.drawable.minus else R.drawable.minus),
                contentDescription = "A minus sign",
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
                    .clickable {
                        if (seats_selected > 0) {
                            seats_selected -= 1;
                            seats_remaining += 1;
                            movie.seats_selected = seats_selected
                            movie.seats_remaining = seats_remaining
                        }
                    })
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = seats_selected.toString(),
                color = Color.White,
                modifier = Modifier

            )
            Spacer(modifier = Modifier.width(5.dp))
            Image(painter = painterResource(id = if (seats_remaining == 0) R.drawable.add else R.drawable.add),
                contentDescription = "A plus sign",
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
                    .clickable {
                        if (seats_remaining > 0) {
                            seats_selected += 1
                            seats_remaining -= 1
                            movie.seats_selected = seats_selected
                            movie.seats_remaining = seats_remaining
                        }
                    })
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            Image(
                painter = painterResource(id = R.drawable.seat),
                contentDescription = "A seat",
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "$seats_remaining seats remaining",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
