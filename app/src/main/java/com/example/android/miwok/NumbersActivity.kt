package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.R.raw
import com.example.android.miwok.R.drawable.number_one
import android.media.MediaPlayer




class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        var mMediaPlayer : MediaPlayer

        val words : ArrayList<Word> = ArrayList()

        words.add(Word("One", "lutti", R.drawable.number_one, R.raw.number_one))
        words.add(Word("Two", "otiiko", R.drawable.number_two, R.raw.number_two))
        words.add(Word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        words.add(Word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        words.add(Word("Five", "massokka", R.drawable.number_five, R.raw.number_five))
        words.add(Word("Six", "temmokka", R.drawable.number_six, R.raw.number_six))
        words.add(Word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("Nine", "wo’e", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("Ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))

        val itemsAdapter = WordAdapter(this, words)
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemsAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Get the {@link Word} object at the given position the user clicked on
            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word
            mMediaPlayer = MediaPlayer.create(this@NumbersActivity, words[position].getAudioResourceId())

            // Start the audio file
            mMediaPlayer.start()
        }
    }
}
