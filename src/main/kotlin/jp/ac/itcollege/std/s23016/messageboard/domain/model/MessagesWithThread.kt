package jp.ac.itcollege.std.s23016.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class MessagesWithThread(
    val id: Long,
    val title: String,
    val thread_id: Long,
    val user_id: Long,
    val message: String,
    val posted_at: LocalDateTime,
    val updated_at: LocalDateTime,
    val created_at: LocalDateTime,
    val deleted: Boolean
)
