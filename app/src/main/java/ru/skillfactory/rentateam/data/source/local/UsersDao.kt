package ru.skillfactory.rentateam.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.skillfactory.rentateam.data.source.local.entity.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} ORDER BY ${UserEntity.COLUMN_ID}")
    fun getUsers(): List<UserEntity>

    @Insert(onConflict = REPLACE)
    fun insertUsers(items: List<UserEntity>)
}