package com.example.cleanarchitecture.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.Note

@Entity(tableName = "note") //tells the room database that the class NoteEntity will be part of our database
data class NoteEntity
    (
    val title:String,
    val content:String,
    @ColumnInfo(name = "creation_date")
    val creationTime:Long,
    @ColumnInfo(name = "update_time")
    val updateTime:Long,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)
{
        companion object{ /*Create a companion object because this can be static.
                           We don't need an instance to create a node entity.*/
            fun fromNote(note: Note)=NoteEntity(note.title,note.content,note.creationTime,note.updateTime)
            /*here we will take a note of Note class And that will be equal, NoteEntity, and here we will pass all the parameters*/
        }
    fun toNote() = Note(title, content, creationTime, updateTime, id)
    /*We're going to say fun toNote() will return a note*/
    }
