package sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sql.domain.User;

import java.sql.SQLException;

class UserDaoTest {

    @DisplayName("DB 쿼리 실행")
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id = "9";
        User user = new User(id, "Kim", "1020");
        userDao.add(user);

        User selectedUser = userDao.select(id);
        Assertions.assertEquals("Kim", selectedUser.getName());
    }
}