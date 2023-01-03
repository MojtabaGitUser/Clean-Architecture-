package com.example.cleanarchitecture.framework.db

import androidx.room.*
@Dao //it will allow the system to know that this is a Dao
interface NoteDao {
    /*
Data Access Object or the Dao. The Dao is basically an interface that defines the functionality
that we will be able to perform on our database.
*/

    @Insert(onConflict = OnConflictStrategy.REPLACE) //it says if we already have that note in our database, then we will replace the new one
    suspend fun addNoteEntity(noteEntity: NoteEntity)/*The reason why we have a suspend is because we will be
    calling this function from a cool routine. to solve the update problem*/

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteEntity(id:Long):NoteEntity?

    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntities():List<NoteEntity>

    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)


}
