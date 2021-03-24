package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.UserDAO;
import kr.or.connect.reservation.dao.UserRoleDAO;
import kr.or.connect.reservation.dto.UserDto;
import kr.or.connect.reservation.dto.UserRoleDto;
import kr.or.connect.reservation.service.UserService;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;


    @Override
    @Transactional(readOnly = true)
    public UserEntity getUser(String loginUserId) {
        UserDto userDto = userDAO.getUserByEmail(loginUserId);
        return new UserEntity(userDto.getId(), userDto.getEmail(), userDto.getPassword());
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        List<UserRoleDto> userRole = userRoleDAO.getRolesByEmail(loginUserId);
        List<UserRoleEntity> userRoleEntity = new ArrayList<>();

        for (UserRoleDto userRoleDto : userRole) {
            userRoleEntity.add(new UserRoleEntity(loginUserId, userRoleDto.getRoleName()));
        }
        return userRoleEntity;
    }
}
