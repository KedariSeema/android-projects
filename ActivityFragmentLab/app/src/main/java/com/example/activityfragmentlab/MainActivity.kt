package com.example.activityfragmentlab

import android.annotation.SuppressLint
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btnShowFragment)
        btn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragmentOfMainActivity())
                .addToBackStack(null)
                .commit()
        }

        val btnShowActivity = findViewById<Button>(R.id.btnNextActivity)
        btnShowActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 100)
           // finish()
        }

        val btnShowActivityWay2 = findViewById<Button>(R.id.btnNextActivityWay2)
        btnShowActivityWay2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startForResultLauncher.launch(intent)
        }
    }

    // traditional approach
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        if(requestCode == 100 && resultCode == RESULT_OK){
            findViewById<TextView>(R.id.tvMsgReceviedFromSecondActivity).text = data?.getStringExtra("result_key_way_1").toString()
        }
    }

    // mordern way
    private val startForResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == RESULT_OK){
            findViewById<TextView>(R.id.tvMsgReceviedFromSecondActivity).text = result.data?.getStringExtra("result_key_way_2").toString()
        }
    }
}