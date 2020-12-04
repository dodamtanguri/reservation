package kr.or.connect.reservation.dao.sql;

public class DisplayinfosSQL {
    public static final String SELECT_PRODUCT_LIST = "SELECT p.id AS 'productId', c.id AS 'categoryId', di.id AS 'displayInfoId',c.name, \n" +
            "p.description, p.content, p.event, \n" +
            "di.opening_hours, di.place_name, di.place_lot,  di.place_street, \n" +
            "di.tel,di.homepage, di.email, di.create_date, di.modify_date, dii.file_id\n" +
            "FROM product p inner Join display_info di  ON  p.id = di.product_id\n" +
            "INNER JOIN category c ON c.id = p.category_id\n" +
            "INNER JOIN display_info_image dii ON dii.display_info_id = di.id\n" +
            "WHERE c.id = :categoryId ORDER by p.id LIMIT :START, 4";
}
