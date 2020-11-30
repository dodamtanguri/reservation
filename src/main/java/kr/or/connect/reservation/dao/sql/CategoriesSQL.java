package kr.or.connect.reservation.dao.sql;

public class CategoriesSQL {
    public static final String SELECT_CATEGORY = "SELECT c.id,c.name,COUNT(*) count from category c, product p, display_info di  where p.category_id = c.id AND di.product_id = p.id GROUP BY c.id ";
}
