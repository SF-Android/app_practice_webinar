package ru.skillfactory.rentateam.data.source.local

import ru.skillfactory.rentateam.data.source.local.entity.UserEntity
import ru.skillfactory.rentateam.domain.model.User
import javax.inject.Inject

class UsersDatabaseMapper
@Inject constructor() {

    fun mapToDBEntities(items: List<User>): List<UserEntity> {
        return items.map { mapDBEntity(it) }
    }

    private fun mapDBEntity(item: User): UserEntity {
        return with(item) {
            UserEntity(
                id,
                email,
                first_name,
                last_name,
                avatarUrl
            )
        }
    }

    fun mapEntitesToUsers(entities: List<UserEntity>): List<User> {
        return entities.map {
            User(
                it.id,
                it.email,
                it.firstName,
                it.lastName,
                "%s %s".format(it.firstName, it.lastName),
                it.avatarUrl
            )
        }
    }
}