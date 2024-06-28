package jp.ac.itcollege.std.s23016.messageboard.presentation.controller

import jp.ac.itcollege.std.s23016.messageboard.aplication.UserService
import jp.ac.itcollege.std.s23016.messageboard.aplication.security.MessageBoardUserDetails
import jp.ac.itcollege.std.s23016.messageboard.domain.model.Users
import jp.ac.itcollege.std.s23016.messageboard.presentation.form.GetUserInfoResponse
import jp.ac.itcollege.std.s23016.messageboard.presentation.form.PostUserRegisterRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/register")
    fun register(@RequestBody request: PostUserRegisterRequest) {
        run {
            userService.register(request.viewName, request.email, request.password)
        }
    }

    @GetMapping("/info")
    fun getInfo(
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): GetUserInfoResponse {
        return userService.find(user.getId()).run {
            GetUserInfoResponse(id, view_Name)
        }
    }
    @DeleteMapping("/delete/{users_id}")
    fun userDelete(@PathVariable users_id: Long) {
        userService.delete(users_id)
    }
}