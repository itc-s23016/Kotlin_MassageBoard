package jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.repository

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Messages
import jp.ac.itcollege.std.s23016.messageboard.domain.repository.MessageRepository
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.MessagesEntity
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.MessagesTables
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.ThreadsEntity
import jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class MessagesRepositoryImpl: MessageRepository {
    override fun createMessage(message: Messages): Messages {
        return transaction {
            val newMessage = MessagesEntity.new {
                threadId = ThreadsEntity[message.thread_id]
                userId = UsersEntity[message.user_id]
                this.message = message.message
                postedAt = message.posted_at
                updatedAt = message.updated_at
                deleted = message.deleted
            }
            newMessage.toMessage()
        }
    }

    override fun getMessageById(id: Long): Messages? {
        return transaction {
            val message = MessagesEntity.findById(id)
            message?.toMessage()
        }
    }

    override fun getMessageByThreadId(threadId: Long): List<Messages> {
        return transaction {
            MessagesEntity.find { MessagesTables.threadId eq threadId }
                .map { it.toMessage() }
        }
    }

    override fun updateMessage(message: Messages): Messages {
        return transaction {
            val messageEntity = MessagesEntity.findById(message.id)
                ?: throw IllegalArgumentException("Message not found with id: ${message.id}")

            messageEntity.apply {
                threadId = ThreadsEntity[message.thread_id]
                userId = UsersEntity[message.user_id]
                this.message = message.message
                postedAt = message.posted_at
                updatedAt = message.updated_at
                deleted = message.deleted
            }

            messageEntity.toMessage()
        }
    }

    override fun deleteMessageById(id: Long) {
        transaction {
            MessagesEntity.findById(id)?.delete()
        }
    }
}