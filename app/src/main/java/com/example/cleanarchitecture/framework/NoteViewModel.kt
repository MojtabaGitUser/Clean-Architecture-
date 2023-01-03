package com.example.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.data.Note
import com.example.core.repository.NoteRepository
import com.example.core.usecase.AddNote
import com.example.core.usecase.GetAllNotes
import com.example.core.usecase.GetNote
import com.example.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/*his class needs to be a viewmodel, but it also needs to have access to a context.
Remember that in our RoomNoteDataSource we have a context that is required here,so that
needs to come from somewhere and it will come from the NoteViewModel.
So first, we're going to add a variable here for our NoteViewModel called application of type application ==> NoteViewModel(application: Application).
And then this class needs to extend from the AndroidViewModel And the AndroidViewModel requires an application in the constructor.==>
AndroidViewModel(application) */
class NoteViewModel(application: Application): AndroidViewModel(application){
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    /*first of all, we will communicate with the room database on a background thread, we use
    coroutines to achieve that asynchronous communication.
    First,I create here a private val coroutinesScope That is going to be CoroutinesScope.
    then pass the Dispatchers.IO .Because the IO dispatcher is the useful when we are
     communicating with some other data source. For instance, if we are communicating through the Web
     with retrofit or with databases or with files on the system, the most efficient dispatcher for
      that particular case is the (Dispatchers.IO)     */
    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetNote(repository),
        GetAllNotes(repository),
        RemoveNote(repository)
    )
    val saved = MutableLiveData<Boolean>()
    /*we're going to have a variable called  saved, which is a live data that will alert whoever is listening
    for us that will be the NoteFragment. It will alert the NoteFragment when the note has been saved in the database.
    OK, so here we have a mutablelivedata.It is mutable because we want to be able to change that value of the live data.*/

    fun saveNote(note: Note){
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }



}