package sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sql.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @DisplayName("DB 쿼리 실행")
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User("8", "Kim", "1020");
        userDao.add(user);

        User selectedUser = userDao.select("8");
        Assertions.assertEquals("Kim", selectedUser.getName());
    }
}