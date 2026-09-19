package com.example.activityfragmentlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activityfragmentlab.databinding.FragmentFirstOfSecondActivityBinding
import com.example.activityfragmentlab.databinding.FragmentSecondOfSecondActivityBinding

class SecondFragmentOfSecondActivity : Fragment() {

    private lateinit var binding: FragmentSecondOfSecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondOfSecondActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("my_request_key", viewLifecycleOwner) { requestKey, bundle ->
                binding.textView.text = bundle.getString("msg")
        }
    }
}