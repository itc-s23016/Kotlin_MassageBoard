package jp.ac.itcollege.std.s23016.messageboard.presentation.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException(override val message: String) : Exception()

@ResponseStatus(HttpStatus.CONFLICT)
class UserIdAlreadyInUseException(override val message: String) : Exception(message)