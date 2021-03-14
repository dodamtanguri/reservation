package kr.or.connect.reservation.dao.sql;

public class reservationSQL {

    public static final String SELECT_RESERVATION_INFOS = "SELECT ri.id, ri.product_id, ri.cancel_flag, ri.display_info_id, ri.user_id, ri.reservation_date, ri.create_date, ri.modify_date FROM reservation_info ri WHERE ri.id = :reservationInfoId";
    public static final String SELECT_RESERVATION_PRICES = "SELECT rip.id,rip.product_price_id,rip.count,rip.reservation_info_id from reservation_info_price rip where rip.id = :reservationPriceId";

    public static final String SELECT_GETRESERVATION_INFOS = "SELECT ri.id, ri.product_id, ri.display_info_id, ri.cancel_flag, p.description, p.content, ri.user_id, sum(pp.price) as 'sumPrice', ri.reservation_date, ri.create_date, ri.modify_date  " +
            " from reservation_info ri\n" +
            "    inner join product p on ri.product_id = p.id\n" +
            "    inner join product_price pp on p.id = pp.product_id\n" +
            "    inner join reservation_info_price rip on ri.id = rip.reservation_info_id\n" +
            " where user_id = :userID group by ri.id desc";

    public static final String UPDATE_CANCEL_FLAG = "UPDATE reservation_info set cancel_flag = 1 WHERE id = :id and user_id = :userID;";
}
