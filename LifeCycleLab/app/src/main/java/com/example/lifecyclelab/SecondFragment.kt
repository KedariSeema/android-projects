package com.example.lifecyclelab

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SecondFragment : Fragment() {
    
    private val LOG : String = "_LIFECYCLE"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG, "SecondFragment() - onAttach | Fragment lifecycle = ${lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG, "SecondFragment() - onCreate | Fragment lifecycle = ${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(LOG, "SecondFragment() - onCreateView | Fragment lifecycle = ${lifecycle.currentState}")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG, "SecondFragment() - onViewCreated | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onViewCreated | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG, "SecondFragment() - onStart | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onStart | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG, "SecondFragment() - onResume | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onResume | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG, "SecondFragment() - onPause | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onPause | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG, "SecondFragment() - onStop | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onStop | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG, "SecondFragment() - onDestroy | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onDestroy | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG, "SecondFragment() - onDestroyView | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onDestroyView | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG, "SecondFragment() - onDetach | Fragment lifecycle = ${lifecycle.currentState}")
        Log.d(LOG, "SecondFragment() - onDetach | View lifecycle = ${viewLifecycleOwner.lifecycle.currentState}")
    }
}

/*
MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()
    FirstFragment() - onAttach
    FirstFragment() - onCreate
    FirstFragment() - onCreateView
    FirstFragment() - onViewCreated
    FirstFragment() - onStart
    FirstFragment() - onResume
    // click on btn in fragment to launch second fragment without addToBackStack() for second fragment
    FirstFragment() - onPause
    FirstFragment() - onStop
    SecondFragment() - onAttach
    SecondFragment() - onCreate
    SecondFragment() - onCreateView
    SecondFragment() - onViewCreated
    SecondFragment() - onStart
    FirstFragment() - onDestroyView
    SecondFragment() - onResume

    // now click on back btn on second fragment
    FirstFragment() - onDestroy // second fragment visible
    FirstFragment() - onDetach
    SecondFragment() - onPause
MainActivity() - onPause()
    SecondFragment() - onStop
MainActivity() - onStop()
    SecondFragment() - onDestroyView
    SecondFragment() - onDestroy
    SecondFragment() - onDetach
MainActivity() - onDestroy()

// after adding back stack to second fragment

MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()
    // clicked btn to launch first fragment
    FirstFragment() - onAttach
    FirstFragment() - onCreate
    FirstFragment() - onCreateView
    FirstFragment() - onViewCreated
    FirstFragment() - onStart
    FirstFragment() - onResume

    // btn clicked to launch second fragment
    FirstFragment() - onPause
    FirstFragment() - onStop
        SecondFragment() - onAttach
        SecondFragment() - onCreate
        SecondFragment() - onCreateView
        SecondFragment() - onViewCreated
        SecondFragment() - onStart
    FirstFragment() - onDestroyView
        SecondFragment() - onResume
        // back btn clicked
        SecondFragment() - onPause
        SecondFragment() - onStop
    FirstFragment() - onCreateView
    FirstFragment() - onViewCreated
    FirstFragment() - onStart
        SecondFragment() - onDestroyView
        SecondFragment() - onDestroy
        SecondFragment() - onDetach
    FirstFragment() - onResume
*/
