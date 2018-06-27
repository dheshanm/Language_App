package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView


class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        var wordsEng : ArrayList<Word> = ArrayList()

        wordsEng.add(Word("One","Lutti"))
        wordsEng.add(Word("Two", "Otiiko"))
        wordsEng.add(Word("Three", "Tolookosu"))
        wordsEng.add(Word("Four", "Oyyisa"))
        wordsEng.add(Word("Five", "Massokka"))
        wordsEng.add(Word("Six", "Temmokka"))
        wordsEng.add(Word("Seven", "Kenekaku"))
        wordsEng.add(Word("Eight", "Kawinta"))
        wordsEng.add(Word("Nine", "Wo’e"))
        wordsEng.add(Word("Ten", "Na’aacha"))

        val itemsAdapter = WordAdapter(this, wordsEng)
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemsAdapter

    }
}
