package com.example.lifecyclelab

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val LOG : String = "_LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG, "MainActivity() - onCreate()")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btnShowFragment)
        btn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view, FirstFragment())
                //.addToBackStack(null)
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG, "MainActivity() - onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG, "MainActivity() - onResume()")
    }
    override fun onPause() {
        super.onPause()
        Log.d(LOG, "MainActivity() - onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG, "MainActivity() - onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG, "MainActivity() - onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG, "MainActivity() - onRestat()")
    }
}
/*
//---------------------------------------------------------------------
// adding fragment without backstack
        on app launch
MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()

        on screen lock/ pressing home btn/
MainActivity() - onPause()
MainActivity() - onStop()

        screen unlock/return to app
MainActivity() - onRestart()
MainActivity() - onStart()
MainActivity() - onResume()

        on back press
MainActivity() - onPause()
MainActivity() - onStop()
MainActivity() - onDestroy()

        on app launch and screen rotate
MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()
MainActivity() - onPause()
MainActivity() - onStop()
MainActivity() - onDestroy()
MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()


//------------------------------------------------------
when fragment adding with addToBackStack
case: app launch -> fragment launch -> back btn press

MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()
    FirstFragment() - onAttach
    FirstFragment() - onCreate
    FirstFragment() - onCreateView
    FirstFragment() - onViewCreated
    FirstFragment() - onStart
    FirstFragment() - onResume
    // after back btn press
    FirstFragment() - onPause
    FirstFragment() - onStop
    FirstFragment() - onDestroyView
    FirstFragment() - onDestroy
    FirstFragment() - onDetach
MainActivity() - onPause()
MainActivity() - onStop()
*/



