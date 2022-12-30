package com.example.cleanarchitecture.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentListBinding
import com.example.cleanarchitecture.databinding.FragmentNoteBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NoteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

   private var fragmentNoteBinding:FragmentNoteBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNoteBinding.inflate(inflater,container,false)
        fragmentNoteBinding = binding
        return binding.root
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val checkButton: FloatingActionButton = (R.id.checkButton) as FloatingActionButton
    fragmentNoteBinding?.checkButton!!.setOnClickListener { Navigation.findNavController(it).popBackStack() }

    }
}