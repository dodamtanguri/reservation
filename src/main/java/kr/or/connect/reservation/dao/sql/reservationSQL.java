package kr.or.connect.reservation.dao.sql;

public class reservationSQL {
    //reservationinfos
    public static final String INSERT_RESERVATION_INFO = "INSERT INTO reservation_info(id,product_id,display_info_id,user_id,reservation_date,cancel_flag,create_date,modify_date) VALUES(default,:productId,:displayinfoId,:userId,STR_TO_DATE(:reservationDate,'%Y-%m-%d'),default,now(),now())";
            //reservationinfos_prices
    public static final String INSERT_RESERVATION_PRICES = "INSERT INTO reservation_info_price VALUES (default,:reservationId,:productPriceId,:count)";

    public static final String SELECT_RESERVATION_INFOS= "select ri.id, ri.product_id, ri.cancel_flag, ri.display_info_id, ri.user_id, ri.reservation_date, ri.create_date, ri.modify_date from reservation_info ri where ri.user_id = :userID order by ri.create_date desc LIMIT 1";
    public static final String SELECT_RESERVATION_PRICES= "SELECT rip.id,rip.product_price_id,rip.count,rip.reservation_info_id from reservation_info_price rip inner join reservation_info ri on rip.reservation_info_id = ri.id\n" +
            "where rip.reservation_info_id = :reservationInfoId LIMIT 1";

}
