package sql.dao;

import sql.domain.User;

import java.sql.*;

public class UserDao<T> {
//    public abstract Connection makeConnection() throws ClassNotFoundException, SQLException;
    private ConnectionMaker<T> connectionMaker;

    public UserDao(ConnectionMaker<T> connectionMaker) {
//        this.awsConnectionMaker = new AWSConnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        /*DB에 쿼리 입력 후 바인딩*/
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        /*쿼리 실행*/
        ps.executeUpdate();

        ps.close(); // 서버 어플리케이션인 경우에는 반드시 작성 필요
        conn.close();
    }

    public User select(String id) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        /*DB에 쿼리 입력 후 바인딩*/
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM users WHERE id = ?");
        ps.setString(1, id);

        /*쿼리 실행*/
        ResultSet resultSet = ps.executeQuery(); // ctrl + enter
        resultSet.next();

        User user = new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"));

        resultSet.close();
        ps.close(); // 서버 어플리케이션인 경우에는 반드시 작성 필요
        conn.close();

        return user;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE * FROM users");
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public int getCount() throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT name, count(name) as cnt FROM users");
        ResultSet rs = ps.executeQuery();
        int ret = Integer.parseInt(rs.getString("cnt"));
        rs.close();
        ps.close();
        conn.close();
        return ret;
    }
}
