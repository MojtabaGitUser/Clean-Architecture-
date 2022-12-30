package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentListBinding


class ListFragment : Fragment() {

    // private lateinit var binding: FragmentList2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var fragmentListBinding:FragmentListBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater,container,false)
        fragmentListBinding = binding
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentListBinding?.addNote?.setOnClickListener { goToNoteDetails() }
        //addNote.setOnClickListener { goToNoteDetails() }

    }

    private fun goToNoteDetails(id: Long = 0L){
        val action:NavDirections = ListFragmentDirections.actionGoToNote(id)
      //  val notesListView: RecyclerView = (R.id.notesListView) as RecyclerView
        Navigation.findNavController(fragmentListBinding?.notesListView!!).navigate(action)


    }

}