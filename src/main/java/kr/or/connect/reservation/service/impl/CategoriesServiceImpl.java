package kr.or.connect.reservation.service.impl;


import kr.or.connect.reservation.service.CategoriesService;
import kr.or.connect.reservation.dao.CategoriesDAO;
import kr.or.connect.reservation.dto.api.CategoriesApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    CategoriesDAO categoriesDAO;
    @Override
    @Transactional(readOnly = true)
    public CategoriesApiDto getCategories() {
        return categoriesDAO.getCategories();
    }
}
