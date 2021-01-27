package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw3.fragments.ListFragment
import com.example.hw3.models.Student

const val ARG_Student_List = "student list"
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FrameFragment, listFragment)
            commit()
        }
    }
}