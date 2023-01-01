package com.example.cleanarchitecture.framework

import com.example.core.usecase.AddNote
import com.example.core.usecase.GetAllNotes
import com.example.core.usecase.GetNote
import com.example.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getNote: GetNote,
    val getAllNotes: GetAllNotes,
    val removeNote: RemoveNote
)

/*I want to create a small class that will allow us to access all
 the use cases that we have created here.
 Inside the data UseCases, I have all the use cases that we have created down below.
 so this allows us to basically instantiate all the use cases and use them in our architecture,
in our view models especially.
The reason why I want to do it like this is because for now, when we will define our use cases,
there will be some code duplication.But if we then remove this and put it inside our dependency injection,
that will allow us to inject our use cases directly where we need them so that it is much easier and more
transparent to use this functionality in this way.
 */



