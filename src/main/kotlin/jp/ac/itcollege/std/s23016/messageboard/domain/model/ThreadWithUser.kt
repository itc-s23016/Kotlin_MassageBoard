package jp.ac.itcollege.std.s23016.messageboard.domain.model

import jp.ac.itcollege.std.s23016.messageboard.domain.types.RoleType
import kotlinx.datetime.LocalDateTime

data class ThreadWithUser (
    val id: Long,
    val title: String,
    val user_id: Long,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime,
    val deleted: Boolean,
    val view_Name: String,
    val email: String,
    val password: String,
    val roleType: RoleType
)