package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.UserSQL.SELECT_USER_BY_EMAIL;

@Repository
public class UserDAO {
    private final RowMapper<UserDto> rowMapper = BeanPropertyRowMapper.newInstance(UserDto.class);
    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public UserDto getUserByEmail(String email) {
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("email", email);
            }
        };
        return jdbc.queryForObject(SELECT_USER_BY_EMAIL, params, rowMapper);
    }

}
