package com.example.pw_task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()
    }

    private fun setupFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment_one,ListFragment()).commit()
        fragmentManager.beginTransaction().replace(R.id.fragment_two,OperationFragment()).commit()
    }

}