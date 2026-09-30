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
import com.example.activitytasklab.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onCreate() instance : ${hashCode()}")
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLaunchFourthActivity.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onDestroy() instance : ${hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityLabConstants.LOG, "ThirdActivity : onRestart()")
    }
}