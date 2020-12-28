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

//    public UserDto(int id, String name, String password, String email, String phone, String createDate, String modifyDate) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.createDate = createDate;
//        this.modifyDate = modifyDate;
//    }
}
