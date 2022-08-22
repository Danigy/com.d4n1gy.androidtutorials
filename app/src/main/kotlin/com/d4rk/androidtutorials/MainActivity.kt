package com.d4rk.androidtutorials
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.d4rk.androidtutorials.ads.Ads
import com.d4rk.androidtutorials.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val splashScreen = installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController by lazy {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
            navHostFragment.navController
        }
        binding.navView.setupWithNavController(navController)
        val darkModeValues = resources.getStringArray(R.array.dark_mode_values)
        when (PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.theme), getString(R.string.theme_def_value))) {
            darkModeValues[0] -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            darkModeValues[1] -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            darkModeValues[2] -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            darkModeValues[3] -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
        }
        val application = application as? Ads ?: return
        application.showAdIfAvailable(this, object : Ads.OnShowAdCompleteListener {
                override fun onShowAdComplete() {
                }
            })
    }
    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}