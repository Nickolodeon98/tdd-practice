package sql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSUserDaoImpl extends UserDao {

    public AWSUserDaoImpl(ConnectionMaker connectionMaker) {
        super(connectionMaker);
    }

    //    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv(); // 환경변수를 사용하여
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        return conn;
    }
}
