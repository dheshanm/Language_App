package com.example.android.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {

    private lateinit var mMediaPlayer : MediaPlayer
    private lateinit var mAudioManager : AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red))
        words.add(Word("Mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow))
        words.add(Word("Dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow))
        words.add(Word("Green", "chokokki", R.drawable.color_green, R.raw.color_green))
        words.add(Word("Brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown))
        words.add(Word("Gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray))
        words.add(Word("Black", "kululli", R.drawable.color_black, R.raw.color_black))
        words.add(Word("White", "kelelli", R.drawable.color_white, R.raw.color_white))

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        val adapter = WordAdapter(this, words)

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        val listView = findViewById<ListView>(R.id.list)

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Get the {@link Word} object at the given position the user clicked on
            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word

            mMediaPlayer = MediaPlayer.create(this@ColorsActivity, words[position].getAudioResourceId())

            // Start the audio file
            mMediaPlayer.start()
            mMediaPlayer.setOnCompletionListener {
                mMediaPlayer.release()
            }

        }

    }

    override fun onStop() {
        super.onStop()
        if(this::mMediaPlayer.isInitialized)
            mMediaPlayer.release()
    }
}
