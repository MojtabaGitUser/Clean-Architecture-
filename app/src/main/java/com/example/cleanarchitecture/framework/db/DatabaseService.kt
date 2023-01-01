package com.example.cleanarchitecture.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [NoteEntity::class], version = 1) //here we have to define our entities that will go into our database.
abstract class DatabaseService: RoomDatabase() {

    /*Database service will allow us to access
     and use the functionality that we have defined so far.*/
    companion object {

        private const val DATABASE_NAME = "note.db"

        private var instance: DatabaseService? = null

        //create the database service
        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        /*here we create the actual database service and getInstance() basically allows this
        this database service(the class that we create) to be a singleton.
        A singleton is a design pattern where we only have
        a single object of a certain type of class in our whole system.*/
        fun getInstance(context: Context): DatabaseService =
            (instance ?: create(context)).also { instance = it }
        /*All requests to our database will go through this
        singleton that is created by the get instance function.*/
    }
    abstract fun noteDao():NoteDao //that will return our interface that we have defined earlier

}