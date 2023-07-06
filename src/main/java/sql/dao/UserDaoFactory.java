//package sql.dao;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class UserDaoFactory {
//
//    @Bean
//    public UserDao<Local> localUserDao() {
//        UserDao<Local> localUserDao = new UserDao<>(new LocalConnectionMaker());
//        return localUserDao;
//    }
//
//    @Bean
//    public UserDao<AWSDo> awsDoUserDao() {
//        UserDao<AWSDo> awsDoUserDao = new UserDao<>(new AWSConnectionMaker());
//        return awsDoUserDao;
//    }
//}
