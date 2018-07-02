package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, FamilyFragment())
                .commit()

    }
}
