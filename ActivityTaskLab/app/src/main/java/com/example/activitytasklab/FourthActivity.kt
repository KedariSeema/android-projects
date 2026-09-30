package com.example.activitytasklab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitytasklab.databinding.ActivityFourthBinding
import com.example.activitytasklab.databinding.ActivityMainBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFourthBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onCreate() instance : ${hashCode()}")

        binding.launchActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java).apply {

                // experiment 1
                //flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                // don't be surprised if existing instance is also destroyed and a new instance is created of activity

                // experiment 2
                //flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                // with combination.it reuses the same activity instance instead of creating new one. but destroy the activity in stack

                // experiment 3
                // in manifest file add launch mode. singleTask. is launch mode. not flag
                // it reuses the same activity instance. but destroy the activity in stack which are above it

                // experiment 4
                // in manifest file add launch mode. singleInstance. is launch mode. not flag
                // it also reuses the same activity but don't destroy the other activity.
            })
        }

        binding.resetTask.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            })
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onDestroy() instance : ${hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityLabConstants.LOG, "FourthActivity : onRestart()")
    }
    
}