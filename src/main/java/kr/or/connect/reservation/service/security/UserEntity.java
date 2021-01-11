package kr.or.connect.reservation.service.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private int userId;
    private String loginUserId;
    private String password;

    public UserEntity(int userId, String loginUserId, String password) {
        this.userId = userId;
        this.loginUserId = loginUserId;
        this.password = password;
    }
}
