package com.sophoun.app.view.activity

import android.os.Bundle
import com.project.app.R
import com.sophoun.app.view.fragment.HomeFragment
import com.sophoun.navigator.FragmentStackNavigator
import com.sophoun.ui.state.BaseActivity

class MainActivity : BaseActivity() {

    val fragmentStackNavigator: FragmentStackNavigator by lazy { FragmentStackNavigator(supportFragmentManager, R.id.nav_host_fragment) }

    override fun layout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentStackNavigator.push(HomeFragment())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (!fragmentStackNavigator.pop()) {
            finish()
        }
    }
}
