package jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Messages
import jp.ac.itcollege.std.s23016.messageboard.domain.model.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessagesEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessagesEntity>(MessagesTables)

    var threadId by ThreadsEntity referencedOn MessagesTables.threadId
    var userId by UsersEntity referencedOn MessagesTables.userId
    var message by MessagesTables.message
    var postedAt by MessagesTables.postedAt
    var updatedAt by MessagesTables.updatedAt
    var deleted by MessagesTables.deleted

    fun toMessage(): Messages {
        return Messages(
            id.value,
            threadId.id.value,
            userId.id.value,
            message,
            postedAt,
            updatedAt,
            deleted
        )
    }
}