package com.example.fitmatchmain


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) BottomNavigationView 찾기
        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 2) NavHostFragment 얻기
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // 3) NavController 꺼내기
        val navController = navHostFragment.navController

        // 4) BottomNavigationView와 연결
        navView.setupWithNavController(navController)
    }
}