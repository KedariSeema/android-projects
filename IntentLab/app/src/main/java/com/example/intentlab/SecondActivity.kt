package com.example.intentlab

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentlab.databinding.ActivityMainBinding
import com.example.intentlab.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var _binding : ActivitySecondBinding? = null
    private val binding : ActivitySecondBinding
        get() = _binding!!

    private var _activityCreateCounter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _activityCreateCounter++

        Log.d(IntentConstants.LOG_TAG, "SecondActivity: onCreate() : activity create counter : $_activityCreateCounter")

        val data = intent.getIntExtra(IntentConstants.EXTRA_TEST_ID, 0)
        Log.d(IntentConstants.LOG_TAG, "Data received from MainActivity is $data")
        binding.tvTitle.text = "${getString(R.string.welcome_to_new_actviity)}. Data recevied from main is $data"

        binding.btnReuse.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            Log.d(IntentConstants.LOG_TAG, "Launching SecondActivity with SINGLE_TOP")
            startActivity(intent)
       }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(IntentConstants.LOG_TAG, "SecondActivity: onNewIntent() : activity create counter : $_activityCreateCounter")
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}