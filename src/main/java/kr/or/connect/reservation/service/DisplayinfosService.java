package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.DisplayinfosDTO;

import java.util.List;

public interface DisplayinfosService {
    public static final Integer START = 0;
    public List<DisplayinfosDTO> getDisplayInfos(Integer categoryId);
}
