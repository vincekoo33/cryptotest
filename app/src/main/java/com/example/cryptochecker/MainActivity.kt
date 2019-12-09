package com.example.cryptochecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment::class.java, null)
            .commit()
    }
}
