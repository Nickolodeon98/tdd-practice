package sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sql.dao.*;
import sql.domain.User;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class) // 테스트 코드에서 활용하기 위함 (다른 클래스들과 분리되어 있기 때문에)
@ContextConfiguration(classes = UserDaoFactory.class) // 여기서는 하나를 부른다. 스프링 부트에서는 configuration 어노테이션이 붙은 모든 클래스를 불러온다.
class UserDaoTest {

    @Autowired // 테스트를 한다.
    ApplicationContext context;

    @DisplayName("로컬 DB 쿼리 실행")
    @Test
    void localAddAndSelect() throws SQLException, ClassNotFoundException {
        /* 싱글톤으로 생성한다. new 를 새로 해주는 것이 아니다.
        * 하지만 이로 인해 한 번 로드할 때 모든 빈을 로드한다는 단점이 있다.*/
        UserDao<AWSDo> userDao = context.getBean("awsDoUserDao", UserDao.class);


        String id = "15";
        User user = new User(id, "Kim", "1020");
        userDao.add(user);

        User selectedUser = userDao.select(id);
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