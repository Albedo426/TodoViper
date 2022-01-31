package com.example.todomain.ui.detail_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todomain.databinding.ActivityDetailBinding
import com.example.todomain.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var  _binding: FragmentDetailBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("text")?.let {
            _binding.textView2.text=it
        }
    }


}