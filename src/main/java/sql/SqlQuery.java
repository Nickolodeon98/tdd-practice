package sql;

import DB.domain.Hospital;
import DB.linereader.ReadLineContext;
import DB.parser.HospitalParser;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class SqlQuery {
    private Connection connection;
    private Map<String, String> env;
    public SqlQuery() throws SQLException, ClassNotFoundException {
        this.env = System.getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private void makeConnection() throws SQLException {
        connection = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }
    public void insert() throws ClassNotFoundException, SQLException {
        makeConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO `Seoul-hospitals`.`seoul-hospitals-table`\n" +
                "(`id`,\n" +
                "`address`,\n" +
                "`district`,\n" +
                "`category`,\n" +
                "`emergency_room`,\n" +
                "`name`,\n" +
                "`subdivision`) VALUES (?, ?, ?, ?, ?, ?, ?)");

        ReadLineContext<Hospital> readLineContext = new ReadLineContext<>(new HospitalParser());
        List<Hospital> hospitalList = readLineContext.readLine("C:\\LikeLion\\2022.10\\221011\\서울시 병의원 위치 정보.csv");

        for (Hospital hospital : hospitalList) {
            ps.setString(1, hospital.getId());
            ps.setString(2, hospital.getAddress());
            ps.setString(3, hospital.getDistrict());
            ps.setString(4, hospital.getCategory());
            ps.setString(5, hospital.getEmergencyRoom());
            ps.setString(6, hospital.getName());
            ps.setString(7, hospital.getSubdivision());
            ps.executeUpdate();
        }

        ps.close();
        connection.close();
    }

    public void select() throws ClassNotFoundException, SQLException {
        makeConnection();

        Statement s = connection.createStatement();
        ResultSet resultSet = s.executeQuery("SELECT * FROM `Seoul-hospitals`.`seoul-hospitals-table`");

        resultSet.next();
        System.out.println(resultSet.getString("name"));

        s.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlQuery sqlQuery = new SqlQuery();
//        sqlQuery.insert();
        sqlQuery.select();
    }
}
