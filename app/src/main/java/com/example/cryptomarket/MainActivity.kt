package com.example.cryptomarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.cryptomarket.constants.Constants
import com.example.cryptomarket.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var constants : Constants

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        constants = Constants(this)

        val navController = findNavController(R.id.nav_host_fragment)
        setupWithNavController(binding.bnv, navController)
    }

    fun showBnv(){
        bnv.isVisible = true
    }

    fun hideBnv(){
        bnv.isVisible = false
    }

    override fun onBackPressed() {
        val currentFragment: Fragment = supportFragmentManager.fragments[0] ?: return
        val controller = Navigation.findNavController(this, R.id.nav_host_fragment)
        if (currentFragment is OnBackPressed) (currentFragment as OnBackPressed).onBackPressed()
        else if (!controller.popBackStack()) finish()
    }
}