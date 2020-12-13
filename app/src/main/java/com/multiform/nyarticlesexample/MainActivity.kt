package com.multiform.nyarticlesexample

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.multiform.nyarticlesexample.databinding.ActivityMainBinding
import com.multiform.nyarticlesexample.databinding.AppBarMainBinding
import com.multiform.nyarticlesexample.ui.ArticlesFragment
import com.multiform.nyarticlesexample.ui.SettingsFragment
import com.multiform.nyarticlesexample.utils.APP_ACTIVITY
import com.multiform.nyarticlesexample.utils.replaceFragment
import com.multiform.nyarticlesexample.utils.viewModel
import com.multiform.nyarticlesexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var appBarBinding: AppBarMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        appBarBinding = mainBinding.appBar
        setContentView(mainBinding.root)

        initFields()

        setAppBarActions()

        setNavigationDrawerActions()
    }

    private fun initFields() {
        APP_ACTIVITY = this
        viewModel = ViewModelProvider(APP_ACTIVITY).get(MainViewModel::class.java)
    }

    private fun setAppBarActions() {

        with(appBarBinding) {

            btnMenu.setOnClickListener {
                closeAllMenu()
                with(mainBinding) {
                    drawerLayout.openDrawer(Gravity.LEFT)
                }
            }

            btnDays.setOnClickListener {
                actionMenu.visibility = View.GONE
                if (daysMenu.visibility == View.GONE) {
                    daysMenu.visibility = View.VISIBLE
                } else daysMenu.visibility = View.GONE
            }

            btnActionMenu.setOnClickListener {
                daysMenu.visibility = View.GONE
                if (actionMenu.visibility == View.GONE) {
                    actionMenu.visibility = View.VISIBLE
                } else actionMenu.visibility = View.GONE
            }

            btnOneDay.setOnClickListener {
                viewModel.getOneDayList()
                closeAllMenu()
            }

            btnSevenDay.setOnClickListener {
                viewModel.getSevenDaysList()
                closeAllMenu()
            }

            btnThirtyDay.setOnClickListener {
                viewModel.getThirtyDaysList()
                closeAllMenu()
            }
        }
    }

    private fun setNavigationDrawerActions() {
        replaceFragment(ArticlesFragment(), false)

        with(mainBinding) {
            navigationView.itemBackground = navigationView.foreground

            navigationView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nyTimes -> {
                        appBarBinding.titleScreen.text = getString(R.string.title_nytimes)
                        appBarBinding.btnDays.visibility = View.VISIBLE
                        replaceFragment(ArticlesFragment(), false)
                    }
                    R.id.settings -> {
                        appBarBinding.titleScreen.text = getString(R.string.title_settings)
                        appBarBinding.btnDays.visibility = View.GONE
                        replaceFragment(SettingsFragment(), false)
                    }
                }
                drawerLayout.close()
                return@setNavigationItemSelectedListener true
            }
        }
    }

    private fun closeAllMenu() {
        with(appBarBinding) {
            daysMenu.visibility = View.GONE
            actionMenu.visibility = View.GONE
        }
    }
}