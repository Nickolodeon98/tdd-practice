package sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sql.dao.*;
import sql.domain.User;

import java.sql.SQLException;

class UserDaoTest {

    @DisplayName("로컬 DB 쿼리 실행")
    @Test
    void localAddAndSelect() throws SQLException, ClassNotFoundException {
        UserDaoFactory userDao = new UserDaoFactory();
        UserDao<Local> localUserDao = userDao.localUserDao();
        String id = "15";
        User user = new User(id, "Kim", "1020");
        localUserDao.add(user);

        User selectedUser = localUserDao.select(id);
        Assertions.assertEquals("Kim", selectedUser.getName());
        Assertions.assertEquals("1020", selectedUser.getPassword());

    }

    @DisplayName("AWS DB 쿼리 실행")
    @Test
    void awsAddAndSelect() throws SQLException, ClassNotFoundException {
        UserDaoFactory userDao = new UserDaoFactory();
        UserDao<AWSDo> awsDoUserDao = userDao.awsDoUserDao();
        String id = "15";
        User user = new User(id, "Kim", "1020");
        awsDoUserDao.add(user);

        User selectedUser = awsDoUserDao.select(id);
        Assertions.assertEquals("Kim", selectedUser.getName());
        Assertions.assertEquals("1020", selectedUser.getPassword());

    }
}