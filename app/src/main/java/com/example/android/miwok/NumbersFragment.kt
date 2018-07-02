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


class NumbersFragment : Fragment() {
    private lateinit var mMediaPlayer : MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_base, container, false)

        val words = ArrayList<Word>()
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