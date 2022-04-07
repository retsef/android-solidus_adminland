package io.solidus.adminland.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import dev.hotwire.turbo.activities.TurboActivity
import dev.hotwire.turbo.delegates.TurboActivityDelegate
import io.solidus.adminland.R
import io.solidus.adminland.util.HOME_URL
import io.solidus.adminland.util.ORDERS_URL
import io.solidus.adminland.util.PRODUCTS_URL

class MainActivity : AppCompatActivity(), TurboActivity, OnItemSelectedListener {
    override lateinit var delegate: TurboActivityDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        delegate = TurboActivityDelegate(this, R.id.main_nav_host)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                delegate.navigate(HOME_URL)
                true
            }
            R.id.orders -> {
                delegate.navigate(ORDERS_URL)
                true
            }
            R.id.products -> {
                delegate.navigate(PRODUCTS_URL)
                true
            }
            else -> false
        }
    }
}
