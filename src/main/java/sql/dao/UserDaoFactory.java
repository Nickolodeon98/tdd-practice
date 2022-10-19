package sql.dao;

public class UserDaoFactory {

    public UserDao<Local> localUserDao() {
        UserDao<Local> localUserDao = new UserDao<>(new LocalConnectionMaker());
        return localUserDao;
    }

    public UserDao<AWSDo> awsDoUserDao() {
        UserDao<AWSDo> awsDoUserDao = new UserDao<>(new AWSConnectionMaker());
        return awsDoUserDao;
    }
}
