package com.example.mobileroomapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobileroomapp.database.dao.UserDao
import com.example.mobileroomapp.database.model.UserModel

@Database( version = 1,entities = [UserModel::class])
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{

        var instance:UserDatabase?=null

        @Synchronized
        fun getInstance(ctx: Context):UserDatabase{

            if(instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    UserDatabase::class.java,
                    "db_user"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }


    }
}