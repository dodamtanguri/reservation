package kr.or.connect.reservation.dao.sql;

public class CommentSQL {
    public static final String SELECT_COMMENT_LIST = " SELECT ruc.id, ruc.product_id as 'productId',ruc.reservation_info_id as 'reservationInfoId', ruc.score,u.email as 'reservationEmail',\n" +
            " ruc.comment, ruc.create_date, ruc.modify_date \n" +
            " FROM reservation_user_comment ruc inner join `user` u on ruc.user_id = u.id \n" +
            " WHERE ruc.product_id  = :productId ORDER by ruc.id DESC LIMIT 0, 5";
    public static final String SELECT_COMMENT_TOTALCOUNT =" SELECT COUNT(ruc.id)\n" +
            " FROM reservation_user_comment ruc inner join `user` u on ruc.user_id = u.id \n" +
            " WHERE ruc.product_id  = :productId";
    public static final String SELECT_COMMENT_IMAGE ="SELECT ruci.id as 'reservationCommentImageId', ruci.reservation_info_id as 'reservationInfoId',ruci.reservation_user_comment_id as 'reservationCommentId',ruci.file_id \n" +
            "from reservation_user_comment_image ruci inner join reservation_user_comment ruc on ruci.reservation_info_id = ruc.reservation_info_id \n" +
            "WHERE ruc.product_id = :productId ";

}
