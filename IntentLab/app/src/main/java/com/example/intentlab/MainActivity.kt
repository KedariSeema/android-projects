package com.example.intentlab

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri
import com.example.intentlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLaunchActivity.setOnClickListener {
            // Experiment A — Explicit Intent
            val explicitIntent = Intent(this, SecondActivity::class.java)
            explicitIntent.putExtra(IntentConstants.EXTRA_TEST_ID, 101)
            startActivity(explicitIntent)
            // finish()
        }

        binding.btnViewSite.setOnClickListener {
            // Experiment B — Implicit Intent
            startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                data = IntentConstants.URL.toUri()
            })
        }

        binding.btnShareText.setOnClickListener {
            // set app that supports the intent action i.e chooser
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Hello this is test msg From Intent Lab")
            }
            startActivity(intent)
        }

        binding.btnSearchForAppropriateActivity.setOnClickListener {
            // here I am deliberately creating an intent which no activity should handle
            val intent = Intent("com.example.intentlab.ACTION_NOT_SUPPORTED")
            try{
                startActivity(intent)
            }catch (e: ActivityNotFoundException) {
                AlertDialog
                    .Builder(this)
                    .setTitle(getString(R.string.dialog_title))
                    .setMessage(getString(R.string.dialog_message))
                    .setPositiveButton(getString(R.string.dialog_button_ok), null)
                    .show()
            }

        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
