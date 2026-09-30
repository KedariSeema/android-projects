package com.example.activitytasklab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitytasklab.databinding.ActivityMainBinding
import com.example.activitytasklab.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onCreate() instance=${hashCode()}")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecondActivity.setOnClickListener {
            Log.d(ActivityLabConstants.LOG, "SecondActivity : launching third activity")
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnLaunchActivityItSelf.setOnClickListener {
            Log.d(ActivityLabConstants.LOG, "SecondActivity : launching activity itself")
            startActivity(Intent(this, SecondActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                // reuse the Activity only when an instance of that Activity is already at the top of the current task.
            })
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onResume() instance=${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onDestroy() instance=${hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onRestart()")
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(ActivityLabConstants.LOG, "SecondActivity: onNewIntent() instance = ${hashCode()}")
    }
}