package gg.edor.rol.service;

import gg.edor.rol.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService{

    @Autowired
    private MainDao mainDAO;

    public Map<String, Object> getDao() {
        return mainDAO.getDao();
    }
}
