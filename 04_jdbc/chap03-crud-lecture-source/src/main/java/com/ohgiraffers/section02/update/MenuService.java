package com.ohgiraffers.section02.update;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public void modifyMenu(Menu menu) {
        Connection con = getConnection();
        int result = 0;

        MenuRepository repository = new MenuRepository();
        result = repository.updateMenu(menu, con);

        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
