package kr.or.connect.reservation.service.security;

import kr.or.connect.reservation.dto.reservationInfoDTO;

import java.util.List;

public interface UserDbService {
    reservationInfoDTO getUser(String loginId);
    List<UserRoleEntity> getUserRoles(String loginUserId);


}
