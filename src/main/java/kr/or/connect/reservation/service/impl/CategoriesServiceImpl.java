package kr.or.connect.reservation.service.impl;


import kr.or.connect.reservation.service.CategoriesService;
import kr.or.connect.reservation.dao.CategoriesDAO;
import kr.or.connect.reservation.dto.api.CategoriesApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesDAO categoriesDAO;

    @Override
    @Transactional(readOnly = true)
    public CategoriesApiDTO getCategories() {
        return categoriesDAO.getCategories();
    }
}
