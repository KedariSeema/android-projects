package com.example.activityfragmentlab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activityfragmentlab.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply{
            btnSecondActivity.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerSecondActivity,FirstFragmentOfSecondActivity())
                    .addToBackStack(null)
                    .commit()
            }

            btnSendMsgToMainActivityByFirstWay.setOnClickListener {
                val intent = Intent()
                intent.putExtra("result_key_way_1", "Hello From Second Activity. Sending By traditional By!!!!")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            btnSendMsgToMainActivityBySecondWay.setOnClickListener {
                val intent = Intent().apply {
                    putExtra("result_key_way_2", "Hello From Second Activity. Sending By Modern Way!!!!")
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}