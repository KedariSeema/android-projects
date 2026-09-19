package com.example.activityfragmentlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activityfragmentlab.databinding.FragmentFirstOfSecondActivityBinding

class FirstFragmentOfSecondActivity : Fragment() {

    private lateinit var binding: FragmentFirstOfSecondActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstOfSecondActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSendMsgToSecondFragmentSecondActivity.setOnClickListener{

                val bundle = Bundle().apply {
                    putString("msg", "Data Received from first fragment")
                }

                parentFragmentManager.setFragmentResult("my_request_key", bundle)

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerSecondActivity,SecondFragmentOfSecondActivity())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}