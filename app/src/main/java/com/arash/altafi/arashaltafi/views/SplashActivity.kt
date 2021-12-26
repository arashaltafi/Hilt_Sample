package com.arash.altafi.arashaltafi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.arash.altafi.arashaltafi.R
import com.arash.altafi.arashaltafi.utils.InternetConnection
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_splash.*

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Check Internet
        try {
            if (InternetConnection.isInternetAvailable(this))
            {
                Handler(Looper.myLooper()!!).postDelayed({
                    startActivity(Intent(this , MainActivity::class.java))
                    finish()
                }, 4000)
            }
            else
            {
                Snackbar.make(coordinator_splash , "اتصال برقرار نیست!", Snackbar.LENGTH_INDEFINITE).setAction("تلاش مجدد") {
                    recreate()
                }
                    .setActionTextColor(ContextCompat.getColor(this , R.color.gold))
                    .setBackgroundTint(ContextCompat.getColor(this , R.color.gray800))
                    .setTextColor(ContextCompat.getColor(this , R.color.white))
                    .show()

            }
        } catch (e:Exception) {
            e.printStackTrace()
        }

    }
}