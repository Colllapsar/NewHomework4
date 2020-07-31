package ru.netology.firsthomework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post ("First post in our network!", "20 august 2020","Colllapsar",false, "0", "7", "1")

        val address = Events.EVENTS.address
        val coordinate = Events.EVENTS.coordinate

        contentTv.text = post.content
        starDateTv.text = post.date
        authorTv.text = post.author
        numberOfLikesTv.text = post.numberOfLikes
        numberOfCommentsTv.text = post.numberOfComments
        numberOfSharesTv.text = post.numberOfShares

        contentTv2.text = Events.EVENTS.content
        starDateTv2.text = Events.EVENTS.date
        authorTv2.text = Events.EVENTS.author
        numberOfLikesTv2.text = Events.EVENTS.numberOfLikes
        numberOfCommentsTv2.text = Events.EVENTS.numberOfComments
        numberOfSharesTv2.text = Events.EVENTS.numberOfShares
        addressTv2.text = Events.EVENTS.address
        coordinateTv2.text = Events.EVENTS.coordinate.toString()

        if (post.numberOfLikes=="0"){
            post.liked = false
            numberOfLikesTv.visibility = View.INVISIBLE
        }
        if (post.numberOfComments=="0"){
            numberOfCommentsTv.visibility = View.INVISIBLE
        }
        if (post.numberOfShares=="0"){
            numberOfSharesTv.visibility = View.INVISIBLE
        }
        var b = false
        if (post.liked){
            likeBtn.setImageResource(R.drawable.ic_baseline_like)
            b = true
        }

        if (Events.EVENTS.numberOfLikes=="0"){
            Events.EVENTS.liked = false
            numberOfLikesTv2.visibility = View.INVISIBLE
        }
        if (Events.EVENTS.numberOfComments=="0"){
            numberOfCommentsTv2.visibility = View.INVISIBLE
        }
        if (Events.EVENTS.numberOfShares=="0"){
            numberOfSharesTv2.visibility = View.INVISIBLE
        }
        var c = false
        if (Events.EVENTS.liked){
            likeBtn2.setImageResource(R.drawable.ic_baseline_like)
            c = true
        }

        likeBtn.setOnClickListener {
            post.liked = !post.liked
            likeBtn.setImageResource(
                if (post.liked) R.drawable.ic_baseline_like
                else R.drawable.ic_baseline_nolike
            )
            if (post.liked&&b) {
                numberOfLikesTv.text = post.numberOfLikes
                numberOfLikesTv.visibility = View.VISIBLE
            }
            if (!post.liked&&b) {
                val a = post.numberOfLikes.toInt()
                numberOfLikesTv.text = (a-1).toString()
                if (numberOfLikesTv.text=="0") numberOfLikesTv.visibility = View.INVISIBLE
            }
            if (post.liked&&!b) {
                val a = post.numberOfLikes.toInt()
                numberOfLikesTv.text = (a+1).toString()
                numberOfLikesTv.visibility = View.VISIBLE
            }
            if (!post.liked&&!b) {
                numberOfLikesTv.text = post.numberOfLikes
                if (numberOfLikesTv.text=="0") numberOfLikesTv.visibility = View.INVISIBLE
            }
        }
            likeBtn2.setOnClickListener {
                Events.EVENTS.liked = !Events.EVENTS.liked
                likeBtn2.setImageResource(
                    if (Events.EVENTS.liked) R.drawable.ic_baseline_like
                    else R.drawable.ic_baseline_nolike
                )
                if (Events.EVENTS.liked&&c) {
                    numberOfLikesTv2.text = Events.EVENTS.numberOfLikes
                    numberOfLikesTv2.visibility = View.VISIBLE
                }
                if (!Events.EVENTS.liked&&c) {
                    val a = Events.EVENTS.numberOfLikes.toInt()
                    numberOfLikesTv2.text = (a-1).toString()
                    if (numberOfLikesTv2.text=="0") numberOfLikesTv2.visibility = View.INVISIBLE
                }
                if (Events.EVENTS.liked&&!c) {
                    val a = Events.EVENTS.numberOfLikes.toInt()
                    numberOfLikesTv2.text = (a+1).toString()
                    numberOfLikesTv2.visibility = View.VISIBLE
                }
                if (!Events.EVENTS.liked&&!c) {
                    numberOfLikesTv2.text = Events.EVENTS.numberOfLikes
                    if (numberOfLikesTv2.text=="0") numberOfLikesTv2.visibility = View.INVISIBLE
                }

        }
        val location= coordinate
        val(lat,lon) = location
        locationBtn2.setOnClickListener{
            val intent = Intent().apply{
                action=Intent.ACTION_VIEW
                data = Uri.parse("geo:$lat,$lon")
            }
            startActivity(intent)
        }
}}