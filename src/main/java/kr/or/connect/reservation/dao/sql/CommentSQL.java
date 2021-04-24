package kr.or.connect.reservation.dao.sql;

public class CommentSQL {
    public static final String SELECT_COMMENT_LIST = "SELECT ruc.id,ruc.product_id,ruc.reservation_info_id, ruc.score, ruc.user_id, ruc.comment FROM reservation_user_comment ruc INNER JOIN product p on ruc.product_id = p.id\n" +
            "INNER JOIN reservation_info ri on ruc.reservation_info_id = ri.id where ruc.user_id = :userId AND ruc.product_id = :productId  ORDER by ruc.id DESC LIMIT :START, 5";

    public static final String SELECT_COMMENT_TOTALCOUNT = " SELECT COUNT(ruc.id)\n" +
            " FROM reservation_user_comment ruc inner join `user` u on ruc.user_id = u.id \n" +
            " WHERE ruc.product_id  = :productId";

    public static final String SELECT_COMMENT_IMAGE = "SELECT ruci.id,ruci.reservation_info_id,ruci.reservation_user_comment_id,\n" +
            "       fi.id AS 'fileId',fi.file_name, fi.save_file_name,fi.content_type,fi.delete_flag,fi.create_date,fi.modify_date\n" +
            "FROM reservation_user_comment_image ruci\n" +
            "    INNER JOIN file_info fi on ruci.file_id = fi.id\n" +
            "    INNER JOIN reservation_user_comment ruc on ruci.reservation_user_comment_id = ruc.id\n" +
            "WHERE ruc.reservation_info_id = :reservationInfoId AND ruc.id = :reservationCommentId;";

    public static final String SELECT_COMMENT_PRODUCTID = "select product_id from reservation_info ri where ri.id = :reservationInfoId and ri.user_id = :userId";

}
