package jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class UsersEntity (id: EntityID<Long>) : LongEntity(id){
    companion object : LongEntityClass<UsersEntity>(UsersTable)

    var view_Name by UsersTable.view_Name
    var email by UsersTable.email
    var password by UsersTable.password

    fun toUser(): Users {
        return Users(
            id.value,
            view_Name,
            email,
            password
        )
    }
}