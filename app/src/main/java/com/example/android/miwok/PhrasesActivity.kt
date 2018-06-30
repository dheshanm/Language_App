package com.example.android.miwok

import android.content.Context
import android.media.AudioManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.media.MediaPlayer
import android.view.View
import android.widget.AdapterView



class PhrasesActivity : AppCompatActivity() {

    private lateinit var mMediaPlayer : MediaPlayer
    private lateinit var mAudioManager : AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going))
        words.add(Word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name))
        words.add(Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is))
        words.add(Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling))
        words.add(Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good))
        words.add(Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming))
        words.add(Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming))
        words.add(Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming))
        words.add(Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go))
        words.add(Word("Come here.", "әnni'nem", R.raw.phrase_come_here))

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        val adapter = WordAdapter(this, words)

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        val listView = findViewById<ListView>(R.id.list)

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter)

        // Set a click listener to play the audio when the list item is clicked on
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                // Get the {@link Word} object at the given position the user clicked on
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(this@PhrasesActivity, words[position].getAudioResourceId())

                // Start the audio file
                mMediaPlayer.start()
                mMediaPlayer.setOnCompletionListener {
                    mMediaPlayer.release()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mMediaPlayer.release()
    }
}
