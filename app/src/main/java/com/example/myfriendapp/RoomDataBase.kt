package com.example.myfriendapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyFriend::class], version = 1)
abstract class RoomDataBase: RoomDatabase(){
    abstract fun myFriendDao(): MyFriendDao

    companion object{
        var INSTANCE: RoomDataBase? = null
        fun getRoomDataBase(context: Context): RoomDataBase? {
            if (INSTANCE == null){
                synchronized(RoomDatabase::class){
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, RoomDataBase::class.java, "MyFriendAppDB").build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}