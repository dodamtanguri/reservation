package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationPrice;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

public class Price  implements RowMapper<ReservationPrice> {

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
