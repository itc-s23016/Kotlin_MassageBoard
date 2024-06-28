package jp.ac.itcollege.std.s23016.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class Messages(
    val id: Long,
    val thread_id: Long,
    val user_id: Long,
    val message: String,
    val posted_at: LocalDateTime,
    val updated_at: LocalDateTime,
    val deleted: Boolean
)
