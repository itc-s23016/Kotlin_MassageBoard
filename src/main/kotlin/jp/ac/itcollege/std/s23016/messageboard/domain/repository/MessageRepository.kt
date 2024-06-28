package jp.ac.itcollege.std.s23016.messageboard.domain.repository

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Messages

interface MessageRepository {
    fun createMessage(message: Messages): Messages

    fun getMessageById(id: Long): Messages?

    fun getMessageByThreadId(threadId: Long): List<Messages>

    fun updateMessage(message: Messages): Messages

    fun deleteMessageById(id: Long)
}