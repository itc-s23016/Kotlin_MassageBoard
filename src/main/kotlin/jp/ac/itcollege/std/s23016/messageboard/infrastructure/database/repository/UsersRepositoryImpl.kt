package jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.repository

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Users
import jp.ac.itcollege.std.s23016.messageboard.domain.repository.UsersRepository
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.UsersEntity
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.UsersTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl : UsersRepository {
    override fun findByEmail(email: String): Users? {
        return transaction {
            UsersEntity.find {
                UsersTable.email eq email
            }.singleOrNull()?.toUser()
        }
    }

    override fun findById(id: Long): Users? {
        return transaction {
            UsersEntity.findById(id)?.toUser()
        }
    }

    override fun createUser(user: Users): Users {
        return transaction {
            UsersEntity.new {
                this.email = user.email
                this.password = user.password
                this.view_Name = user.view_Name
            }.toUser()
        }
    }

    override fun updateUser(user: Users): Users {
        return transaction {
            val usersEntity = UsersEntity.findById(user.id)
                ?: throw IllegalArgumentException("User not found with id:${user.id}")
            usersEntity.apply {
                email = user.email
                password = user.password
                view_Name = user.view_Name
            }
            usersEntity.toUser()
        }
    }

    override fun deleteUser(id: Long) {
        transaction {
            val userEntity = UsersEntity.findById(id)
                ?: throw IllegalArgumentException("User not found with id: ${id}")
            userEntity.delete()
        }
    }

    override fun save(user: Users): Users {
        return if (user.id == 0L) {
            createUser(user)
        } else {
            updateUser(user)
        }
    }
}