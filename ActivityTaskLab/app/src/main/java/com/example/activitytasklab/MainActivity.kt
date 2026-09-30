package com.example.activitytasklab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitytasklab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ActivityLabConstants.LOG, "MainActivity : onCreate() instance: ${hashCode()}")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainActivity.setOnClickListener {
            Log.d(ActivityLabConstants.LOG, "MainActivity : launching second activity")
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onDestroy() instance : ${hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityLabConstants.LOG, "MainActivity : onRestart()")
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(ActivityLabConstants.LOG, "MainActivity : onNewIntent() instance: ${hashCode()}")
    }
}