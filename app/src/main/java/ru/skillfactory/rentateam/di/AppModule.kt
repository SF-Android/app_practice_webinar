package ru.skillfactory.rentateam.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.skillfactory.rentateam.data.source.remote.dto.UserResponse
import ru.skillfactory.rentateam.data.source.remote.dto.UsersResponse
import ru.skillfactory.rentateam.data.source.remote.UsersMapperImpl
import ru.skillfactory.rentateam.data.repository.UsersRepositoryImpl
import ru.skillfactory.rentateam.domain.mapper.UsersMapper
import ru.skillfactory.rentateam.domain.repository.UsersRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Reusable
    abstract fun bindUsersRepository(usersRepository: UsersRepositoryImpl): UsersRepository

    @Binds
    @Reusable
    abstract fun bindUsersMapper(
        usersMapper: UsersMapperImpl
    ): @JvmSuppressWildcards UsersMapper<UsersResponse, UserResponse>
}