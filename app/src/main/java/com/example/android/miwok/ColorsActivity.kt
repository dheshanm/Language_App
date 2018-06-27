package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Red", "Weṭeṭṭi"))
        words.add(Word("Mustard yellow", "Chiwiiṭә"))
        words.add(Word("Dusty yellow", "Topiisә"))
        words.add(Word("Green", "Chokokki"))
        words.add(Word("Brown", "Takaakki"))
        words.add(Word("Gray", "Topoppi"))
        words.add(Word("Black", "Kululli"))
        words.add(Word("White", "Kelelli"))

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
    }
}
