package kr.or.connect.reservation.service.security;

import kr.or.connect.reservation.dto.ReservationInfo;

import java.util.List;

public interface UserDbService {
    UserEntity getUser(String loginId);
    List<UserRoleEntity> getUserRoles(String loginUserId);


}
