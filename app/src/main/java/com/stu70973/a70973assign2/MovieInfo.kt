package com.stu70973.a70973assign2

import kotlin.random.Random

object MovieInfo {
    val movieList = listOf(
        dataType(
            name = "DUNE: PART TWO",
            imageId = R.drawable.banner1,
            certification = R.drawable.age12,
            description = "Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against" +
                    " the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the" +
                    " known universe, he endeavors to prevent a terrible future only he can foresee.\n",
            starring = arrayOf("Timothée Chalamet", "Florence Pugh", "Zendaya" , "Souheila Yacoub", "Austin Butler"),
            running_time_mins = 166,
            seats_remaining = Random.nextInt(0, 15),
            seats_selected = 0,
            id = 0,
        ),
        dataType(
            name = "GHOSTBUSTERS",
            imageId = R.drawable.banner3,
            certification = R.drawable.age12,
            description = "In Ghostbusters: Frozen Empire, the Spengler family returns to where it all started – the iconic New York City firehouse – " +
                    " Ghostbusters new and old must join forces to protect their home and save the world from a second Ice Age.\n",
            starring = arrayOf("Paul Rudd", "Bill Murray", "Finn Wolfhard", "Dan Aykroud", "Annie Potts", "Mckenna Grace", "Ernie Hudson"),
            running_time_mins = 144,
            seats_remaining = Random.nextInt(0, 15),
            seats_selected = 0,
            id = 1
        ),
        dataType(
            name = "IMMACULATE",
            imageId = R.drawable.banner4,
            certification = R.drawable.age12,
            description = "Cecilia, a woman of devout faith, is warmly welcomed to the picture-perfect " +
                    "Italian countryside where she is offered a new role at an illustrious convent. " +
                    "But it becomes clear to Cecilia that her new home harbors dark and horrifying secrets.\n",
            starring = arrayOf("Sydney Sweeney", "Benedetta Porcaroli", "Álvaro Morte", "Simona Tabasco"),
            running_time_mins = 89,
            seats_remaining = Random.nextInt(0, 15),
            seats_selected = 0,
            id = 2
        ),
        dataType(
            name = "IMAGINARY",
            imageId = R.drawable.banner2,
            certification = R.drawable.age12,
            description = "From Blumhouse, the genre-defining masterminds behind FIVE NIGHTS AT FREDDY’S and M3GAN. " +
                    "When Jessica (DeWanda Wise) moves back into her childhood home with her, " +
                    " Jessica intervenes only to realize Chauncey is much more than the stuffed toy bear she believed him to be.\n",
            starring = arrayOf("Betty Buckley", "DeWanda Wise", "Tom Payne"),
            running_time_mins = 104,
            seats_remaining = Random.nextInt(0, 15),
            seats_selected = 0,
            id = 3
        )
    )
}
