package com.example.nigerianlunchtray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.nigerianlunchtray.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Binding object instance corresponding to activity_main.xml layout
    private lateinit var _binding: ActivityMainBinding

    // NavController to be retrieved later
    private lateinit var _navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        // Retrieve NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController
    }
}
