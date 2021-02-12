package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.reservationDAO;
import kr.or.connect.reservation.dto.ReservationBody;
import kr.or.connect.reservation.dto.ReservationDTO;
import kr.or.connect.reservation.dto.ReservationPriceBody;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final reservationDAO reservationDao;

    @Autowired
    public ReservationServiceImpl(reservationDAO reservationDao) {
        this.reservationDao = reservationDao;
    }


    @Override
    public void insertInfo(ReservationBody body) {
        reservationDao.addInfo(body);
    }

    @Override
    public void insertPrice(ReservationPriceBody priceBody) {
        reservationDao.addPrice(priceBody);
    }


    @Override
    public ReservationApiDTO getReservationInfo(ReservationDTO dto) {
  reservationDao.getReservationPrice(dto);
    }

    @Override
    public reservationInfoDTO getUser(String loginId) {
        reservationInfoDTO reservation = reservationDao.getReservationInfo(loginId);
        return reservation;
    }




    @Override
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        return null;
    }
}
