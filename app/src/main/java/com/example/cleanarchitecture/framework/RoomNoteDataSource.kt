package com.example.cleanarchitecture.framework

import android.content.Context
import com.example.cleanarchitecture.framework.db.DatabaseService
import com.example.cleanarchitecture.framework.db.NoteEntity
import com.example.core.data.Note
import com.example.core.repository.NoteDataSource

class RoomNoteDataSource(context: Context):NoteDataSource {
    /* we're going to connect the database that we have defined here with the
    the data and especially the repository that we have created inside the core module.
    OK, so for that, we will need a class that implements this interface that we have defined here.
    So we have defined the NodeDataSource class in module package.*/
    val noteDao = DatabaseService.getInstance(context).noteDao()
    /*First here I'm going to define a value noteDao. That is going to be DatabaseService.getInstance(),
     and we're going to pass the context here so this is how we will actually access the database. */

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }
    /*Again, this returns a list of entities, so we need to map that to a list of notes
     and we can say dot map.
     it.toNote() so that map returns each individual entry in our list.
     */


    override suspend fun delete(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))

    /*basically that simply transforms the interface(NoteDataSource) to access to our database through
     the methods that we have defined in our Dao.*/

}