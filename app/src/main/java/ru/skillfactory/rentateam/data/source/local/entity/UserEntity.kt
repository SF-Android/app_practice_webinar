package ru.skillfactory.rentateam.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.skillfactory.rentateam.data.source.local.entity.UserEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String? = null,
) {
    companion object {
        const val TABLE_NAME = "USERS"
        const val COLUMN_ID = "id"
    }
}