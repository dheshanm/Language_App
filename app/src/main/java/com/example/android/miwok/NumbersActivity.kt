package com.example.android.miwok

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_numbers.*

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        val wordsEng = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")

        val layout : ConstraintLayout = findViewById(R.id.rootView)
        val set : ConstraintSet = ConstraintSet()
        var previousId = rootView.id

        for (index in 0..wordsEng.size-1){
            val wordView = TextView(this)
            wordView.text = wordsEng[index]
            wordView.setTextColor(Color.BLACK)
            wordView.id = View.generateViewId()
            layout.addView(wordView)

            set.connect(wordView.id, ConstraintSet.TOP, previousId, ConstraintSet.TOP,60 )
            //set.connect(wordView.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 60)
            set.connect(wordView.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 60)

            previousId = wordView.id
            set.constrainHeight(wordView.id,150)
            set.applyTo(layout)
        }

        /*
        // Example Code to add Two Buttons Dynamically
        // Source : https://stackoverflow.com/questions/41666566/constraintlayout-how-to-add-several-views-programmatically

        val button = Button(this)
        button.setText("Hello")
        button.setId(View.generateViewId())           // <-- Important
        layout.addView(button)
        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        set.connect(button.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(button.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.constrainHeight(button.getId(), 200)
        set.applyTo(layout)


        val newButton = Button(this)
        newButton.setText("Yeeey")
        newButton.setId(View.generateViewId())
        layout.addView(newButton)
        set.connect(newButton.getId(), ConstraintSet.BOTTOM, button.getId(), ConstraintSet.TOP, 0)
        set.connect(newButton.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(newButton.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.constrainHeight(newButton.getId(), 200)
        set.applyTo(layout)*/


    }
}
