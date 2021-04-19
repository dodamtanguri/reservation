package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String createDate;
    private String modifyDate;


}
