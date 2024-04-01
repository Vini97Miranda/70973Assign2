package com.stu70973.a70973assign2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AndroidNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routers.FirstScreen.route,
    ) {
        composable(Routers.FirstScreen.route)
        {
            MovieHome(navController = navController)
        }
        composable(Routers.SecondScreen.route + "/{movieId}")
        { backStackEntry ->
            val arg = backStackEntry.arguments?.getString("movieId")
            var id = 1
            if(arg != null)
                id = arg.toInt();
            val movie = MovieInfo.movieList.find { it.id == id}
            //val movie = DataProvider.movieList.find { it.name == id}
            if(movie != null)
                Screens(movie,navController = navController)
        }
    }
}


