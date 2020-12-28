package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {
    private int id;
    private int userId;
    private String roleName;

    public UserRoleDto() {
    }

    public UserRoleDto(int userId, String roleName) {
        this.userId = userId;
        this.roleName = roleName;
    }
}
