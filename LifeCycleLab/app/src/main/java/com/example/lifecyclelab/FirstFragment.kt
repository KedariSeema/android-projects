package com.example.lifecyclelab

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.lifecyclelab.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding : FragmentFirstBinding? = null

    private val binding : FragmentFirstBinding
        get() = _binding!!

    private val LOG : String = "_LIFECYCLE"
    private var viewCreatedCounter = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG, "FirstFragment() - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG, "FirstFragment() - onCreate instance=${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewCreatedCounter++
        Log.d(LOG, "FirstFragment() - onCreateView instance=${hashCode()}, count=$viewCreatedCounter")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG, "FirstFragment() - onViewCreated ")

        viewLifecycleOwner.lifecycle.addObserver(
            object: DefaultLifecycleObserver {
                override fun onCreate(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onCreate")
                }

                override fun onStart(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onStart")
                }

                override fun onResume(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onResume")
                }

                override fun onPause(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onPause")
                }

                override fun onStop(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onStop")
                }

                override fun onDestroy(owner: LifecycleOwner) {
                    Log.d(LOG, "VIEW → onDestroy")
                }
            }
        )

        binding.btnFirstFragment.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view,SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG, "FirstFragment() - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG, "FirstFragment() - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG, "FirstFragment() - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG, "FirstFragment() - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG, "FirstFragment() - onDestroy")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
        Log.d(LOG, "FirstFragment() - onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG, "FirstFragment() - onDetach")
    }
}

/*
When app open -> launch the fragment -> back btn press
MainActivity() - onCreate()
MainActivity() - onStart()
MainActivity() - onResume()
    FirstFragment() - onAttach
    FirstFragment() - onCreate
    FirstFragment() - onCreateView
    FirstFragment() - onViewCreated
    FirstFragment() - onStart
    FirstFragment() - onResume
    FirstFragment() - onPause
MainActivity() - onPause()
    FirstFragment() - onStop
MainActivity() - onStop()


*/
