package kr.or.connect.reservation.dao.sql;

public class reservationSQL {
    //reservationinfos
    public static final String INSERT_RESERVATION_INFO = "INSERT INTO reservation_info(id,product_id,display_info_id,user_id,reservation_date,cancel_flag,create_date,modify_date) VALUES(default,:productId,:displayinfoId,:userId,STR_TO_DATE(:reservationDate,'%Y-%m-%d'),default,now(),now())";
            //reservationinfos_prices
    public static final String INSERT_RESERVATION_PRICES = "INSERT INTO reservation_info_price VALUES (default,:reservationId,:productPriceId,:count)";

    public static final String SELECT_RESERVATION_INFOS= "select * from reservation_info where reservation_info_id = :reservationInfoId";
    public static final String SELECT_RESERVATION_PRICES= "SELECT * from reservation_info_price where reservation_info_id = :reservationInfoId";

}
