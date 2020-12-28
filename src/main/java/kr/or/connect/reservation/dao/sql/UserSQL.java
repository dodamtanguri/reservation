package kr.or.connect.reservation.dao.sql;

public class UserSQL {
    public static final String SELECT_USER_BY_EMAIL ="SELECT u.id, u.`password`,u.name, u.email, u.phone, u.create_date, u.modify_date from `user` u where u.email = :email";
    public static final String SELECT_USER_ROLE_BY_EMAIL ="SELECT ur.id, ur.user_id, ur.role_name from user_role ur INNER JOIN `user` u  on ur.user_id = u.id WHERE u.email = :email";
}
