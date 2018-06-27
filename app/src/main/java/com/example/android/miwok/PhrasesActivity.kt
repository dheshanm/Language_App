package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        // Create a list of words
        val words = ArrayList<Word>()
        words.add(Word("Where are you going?", "minto wuksus"))
        words.add(Word("What is your name?", "tinnә oyaase'nә"))
        words.add(Word("My name is...", "oyaaset..."))
        words.add(Word("How are you feeling?", "michәksәs?"))
        words.add(Word("I’m feeling good.", "kuchi achit"))
        words.add(Word("Are you coming?", "әәnәs'aa?"))
        words.add(Word("Yes, I’m coming.", "hәә’ әәnәm"))
        words.add(Word("I’m coming.", "әәnәm"))
        words.add(Word("Let’s go.", "yoowutis"))
        words.add(Word("Come here.", "әnni'nem"))

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
