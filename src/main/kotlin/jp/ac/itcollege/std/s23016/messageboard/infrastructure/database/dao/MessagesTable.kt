package jp.ac.itcollege.std.s23016.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime


object MessagesTables : LongIdTable("message") {
    val threadId = reference("thread_id", ThreadsTable)
    val userId = reference("user_id", UsersTable)
    val message = varchar("message", 256)
    val postedAt = datetime("posted_at")
    val updatedAt = datetime("updated_at")
    val deleted = bool("deleted").default(false)
}