package com.example.android.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView

class ColorsFragment : Fragment() {

    private lateinit var mMediaPlayer : MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_base, container,false)

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
        val adapter = WordAdapter(activity!!.applicationContext, words)

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        val listView = view.findViewById<ListView>(R.id.list)

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Get the {@link Word} object at the given position the user clicked on
            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word

            mMediaPlayer = MediaPlayer.create(activity, words[position].getAudioResourceId())

            // Start the audio file
            mMediaPlayer.start()
            mMediaPlayer.setOnCompletionListener {
                mMediaPlayer.release()
            }

        }

        return view
    }

    override fun onStop() {
        super.onStop()
        if(this::mMediaPlayer.isInitialized)
            mMediaPlayer.release()
    }
}
