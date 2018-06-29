package com.example.android.miwok

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * [WordAdapter] is an [ArrayAdapter] that can provide the layout for each list item
 * based on a data source, which is a list of [Word] objects.
 */
class WordAdapter
/**
 * Create a new [WordAdapter] object.
 *
 * @param context is the current context (i.e. Activity) that the adapter is being created in.
 * @param words is the list of [Word]s to be displayed.
 */
(context: Context, words: ArrayList<Word>) : ArrayAdapter<Word>(context, 0, words) {

    override fun getView(position: Int, currentView: View?, parent: ViewGroup): View {
        // Check if an existing view is being reused, otherwise inflate the view
        var listItemView = currentView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, parent, false)
        }

        val currentWord = getItem(position)

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        val miwokTextView = listItemView!!.findViewById<TextView>(R.id.miwok_text_view)
        miwokTextView.text = currentWord!!.getMiwokTranslation()

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        val defaultTextView = listItemView.findViewById<TextView>(R.id.default_text_view)
        defaultTextView.text = currentWord.getDefaultTranslation()

        val placeHolderImageView = listItemView.findViewById<ImageView>(R.id.imageHolder)
        placeHolderImageView.setImageResource(currentWord.getResourceId())

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView
    }
}