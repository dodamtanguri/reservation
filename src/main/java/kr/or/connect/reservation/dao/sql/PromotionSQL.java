package kr.or.connect.reservation.dao.sql;

public class PromotionSQL {
    public static final String SELECT_PROMOTION_LIST = "SELECT pr.id as 'PromotionId', p.id as 'ProductId',c.id as 'CategoryId',c.name, p.description, fi.id as 'fileId' from product p \n" +
            "inner join promotion pr on p.id = pr.product_id \n" +
            "inner join category c on p.category_id = c.id \n" +
            "inner join product_image pi on p.id = pi.product_id \n" +
            "inner join file_info fi  on pi.file_id = fi.id \n" +
            "WHERE file_name like '%ma%' GROUP BY pr.id";
}
