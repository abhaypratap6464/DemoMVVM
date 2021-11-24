package com.android.example.demoMvvM.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.android.example.demoMvvM.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()
                    ?.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}