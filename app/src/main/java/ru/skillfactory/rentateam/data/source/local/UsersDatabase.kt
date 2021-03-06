package ru.skillfactory.rentateam.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.skillfactory.rentateam.data.source.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun getUsersDao(): UsersDao
}