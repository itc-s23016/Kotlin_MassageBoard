package jp.ac.itcollege.std.s23016.messageboard.aplication

import jp.ac.itcollege.std.s23016.messageboard.domain.repository.MessageRepository
import org.apache.logging.log4j.message.Message
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageRepository: MessageRepository
)