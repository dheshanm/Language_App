package com.example.android.miwok

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

class Word
    (defaultTranslation: String, miwokTranslation: String, audioResourceId : Int) {
    /** Default translation for the word  */
    private var mDefaultTranslation: String = defaultTranslation

    /** Miwok translation for the word  */
    private var mMiwokTranslation: String = miwokTranslation

    private var mAudioResourceId = audioResourceId

    private var mImageResourceId : Int = 0

    constructor(defaultTranslation: String, miwokTranslation: String, resourceId : Int, audioResourceId: Int) : this(defaultTranslation, miwokTranslation, audioResourceId){
        mImageResourceId = resourceId
    }

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

    fun getResourceId() : Int {
        return mImageResourceId
    }

    fun getAudioResourceId() : Int {
        return mAudioResourceId
    }
}