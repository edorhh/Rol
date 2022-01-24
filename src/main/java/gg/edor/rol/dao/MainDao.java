package gg.edor.rol.dao;

import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class MainDao extends AbstractDao {
    private static final String NAME_SPACE = "MAIN.";

    public Map<String, Object> getDao() {
        return select(NAME_SPACE + "GET_DATA");
    }
}