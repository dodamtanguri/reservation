package kr.or.connect.reservation.dao.sql;

public class reservationSQL {
    //reservationinfos
    public static final String INSERT_RESERVATION_INFO = "INSERT INTO reservation_info(id,product_id,display_info_id,user_id,reservation_date,cancel_flag,create_date,modify_date) " +
            "VALUES(default,:productId,:displayinfoId,:userId,:reservationDate,default,:createDate,:modifyDate)";
            //reservationinfos_prices
    public static final String INSERT_RESERVATION_PRICES = "INSERT INTO reservation_info_price VALUES (default,:reservationId,:productPriceId,:count)";

}
