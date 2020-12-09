package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;

public interface DisplayinfosService {
    public static final Integer START = 0;

    public DisplayinfosApiDto getDisplayInfos(int categoryId);

}
