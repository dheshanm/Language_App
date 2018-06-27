package com.example.android.miwok

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

class Word
    (defaultTranslation: String, miwokTranslation: String) {
    /** Default translation for the word  */
    private var mDefaultTranslation: String = defaultTranslation

    /** Miwok translation for the word  */
    private var mMiwokTranslation: String = miwokTranslation

    /**
     * Get the default translation of the word.
     */
    fun getDefaultTranslation(): String {
        return mDefaultTranslation
    }

    /**
     * Get the Miwok translation of the word.
     */
    fun getMiwokTranslation(): String {
        return mMiwokTranslation
    }
}