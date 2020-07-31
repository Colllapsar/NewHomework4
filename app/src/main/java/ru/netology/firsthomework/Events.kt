package ru.netology.firsthomework

enum class Events(val content:String,
                  val date:String,
                  val author:String,
                  var liked:Boolean = true,
                  val numberOfLikes:String,
                  val numberOfComments:String,
                  val numberOfShares:String,
                  val address:String,
                  val coordinate: Pair<Double, Double>){
    EVENTS (
        "Second post in our network!",
        "21 august 2020",
        "Colllapsar",
        false,
        "2",
        "4",
        "3",
        "Kaliningrad",
        55.01 to 65.22)
}