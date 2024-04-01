package com.stu70973.a70973assign2

sealed class Routers(val route: String) {
    object FirstScreen : Routers("Home")
    object SecondScreen : Routers("movie_screen")
}