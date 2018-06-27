package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Father", "әpә"))
        words.add(Word("Mother", "әṭa"))
        words.add(Word("Son", "Angsi"))
        words.add(Word("Daughter", "tune"))
        words.add(Word("Older brother", "Taachi"))
        words.add(Word("Younger brother", "Chalitti"))
        words.add(Word("Older sister", "Teṭe"))
        words.add(Word("Younger sister", "Kolliti"))
        words.add(Word("Grandmother ", "Ama"))
        words.add(Word("Grandfather", "Paapa"))

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
    }
}
