package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

//    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/loginform")
    public String loginform() {
        return "/users/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error") String loginError) {
        return "/users/loginerror";
    }

}
