package jp.ac.itcollege.std.s23016.messageboard.aplication.security/*

import jp.ac.itcollege.std.s23016.messageboard.domain.model.Users
import jp.ac.itcollege.std.s23016.messageboard.domain.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val usersRepository: UsersRepository
) {
    fun findUser(email: String): Users? {
        return usersRepository.find(email)
    }
}*/