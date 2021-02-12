package kr.or.connect.reservation.dao;

import com.mysql.cj.result.Row;
import kr.or.connect.reservation.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.UserSQL.SELECT_USER_ROLE_BY_EMAIL;

@Repository
public class UserRoleDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<UserRoleDto> rowMapper = BeanPropertyRowMapper.newInstance(UserRoleDto.class);

    @Autowired
    public UserRoleDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<UserRoleDto> getRolesByEmail(String email) {
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("email", email);
            }
        };
        return jdbc.query(SELECT_USER_ROLE_BY_EMAIL, params, rowMapper);
    }
}
