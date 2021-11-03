package ru.skillfactory.rentateam.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.skillfactory.rentateam.data.source.local.UsersDao
import ru.skillfactory.rentateam.data.source.local.UsersDatabase
import javax.inject.Singleton

private const val DB_NAME = "users_db"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(context, UsersDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUsersDao(db: UsersDatabase): UsersDao {
        return db.getUsersDao()
    }
}