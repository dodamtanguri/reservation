package kr.or.connect.reservation.dao.sql;

public class DisplayInfoSQL {

    public static final String SELECT_DISPLAYINFO_BY_PRODUCT = "SELECT p.id AS 'productId', c.id AS 'categoryId', di.id AS 'displayInfoId',c.name, \n" +
            "p.description, p.content, p.event, \n" +
            "di.opening_hours, di.place_name, di.place_lot,  di.place_street, \n" +
            "di.tel,di.homepage, di.email, di.create_date, di.modify_date, pi2.file_id\n" +
            "from product p inner join display_info di on p.id = di.product_id\n" +
            "INNER join category c on c.id = p.category_id \n" +
            "inner join display_info_image dii ON dii.display_info_id = di.id\n" +
            "inner join product_image pi2 on pi2.product_id = p.id \n" +
            "where pi2.`type` = 'ma' and  di.id = :displayInfoId";

    public static final String SELECT_DISPLAYINFO_BY_PRODUCT_IMAGE ="SELECT pi2.product_id as 'productId',pi2.id as 'productImageId',pi2.`type`,fi.id as 'fileInfoId',fi.file_name ,fi.save_file_name ,\n" +
            "fi.content_type , fi.delete_flag , fi.create_date , fi.modify_date \n" +
            "from file_info fi inner join product_image pi2 on pi2.file_id = fi.id where pi2.`type` = 'ma' AND pi2.product_id =:displayInfoId\n";

    public static final String SELECT_DISPLAYINFO_IMAGE = "SELECT dii.id, di.id as 'displayinfoId', fi.id as 'fileId', fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date,fi.modify_date \n" +
            "from display_info_image dii inner join display_info di on dii.display_info_id = di.id \n" +
            "INNER JOIN file_info fi on dii.file_id = fi.id WHERE di.id = :displayInfoId\n";

    public static final String SELECT_COMMENT_AVERAGE ="SELECT TRUNCATE(AVG(score),0) as 'avgScore' from reservation_user_comment ruc";


    public static final String SELECT_PRODUCT_PRICES ="SELECT pp.id, p.id as 'productId',pp.price_type_name, pp.price, pp.discount_rate, pp.create_date, pp.modify_date \n" +
            "from product p inner Join product_price pp on p.id = pp.product_id \n" +
            "WHERE p.id = :displayInfoId ORDER by pp.price";

}
