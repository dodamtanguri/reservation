package kr.or.connect.reservation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DisplayinfosDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public DisplayinfosDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }


}
