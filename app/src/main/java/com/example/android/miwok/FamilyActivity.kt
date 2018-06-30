package com.example.android.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {

    private lateinit var mMediaPlayer : MediaPlayer
    private lateinit var mAudioManager : AudioManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Father", "әpә", R.drawable.family_father, R.raw.family_father))
        words.add(Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother))
        words.add(Word("Son", "angsi", R.drawable.family_son, R.raw.family_son))
        words.add(Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter))
        words.add(Word("Older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother))
        words.add(Word("Younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother))
        words.add(Word("Older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister))
        words.add(Word("Younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister))
        words.add(Word("Grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother))
        words.add(Word("Grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather))

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

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Get the {@link Word} object at the given position the user clicked on
            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word
            mMediaPlayer = MediaPlayer.create(this@FamilyActivity, words[position].getAudioResourceId())

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
