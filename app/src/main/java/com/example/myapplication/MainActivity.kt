package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView= findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.sharedprefrence -> {
                    replaceFragment(SharePreference())
                    true
                }
                R.id.manager -> {
                    replaceFragment(Manager())
                    true
                }
                else -> false
            }
        }
        replaceFragment(SharePreference())
    }

    private fun replaceFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_container, fragment).commit()
    }

}