package com.example.android.miwok


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_base.*

class FamilyFragment : Fragment() {

    private lateinit var mMediaPlayer : MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_base, container,false)

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
