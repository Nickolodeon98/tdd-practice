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
        this.connection = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));

    }

    public void insert() throws ClassNotFoundException, SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO seoul-hospitals-table VALUES (?, ?, ?, ?, ?, ?, ?)");

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
        Statement s = connection.createStatement();
        ResultSet resultSet = s.executeQuery("SELECT name FROM seoul-hospitals-table");

        resultSet.next();
        System.out.println(resultSet.getString("name"));

        s.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlQuery sqlQuery = new SqlQuery();
        sqlQuery.insert();
        sqlQuery.select();
    }
}
