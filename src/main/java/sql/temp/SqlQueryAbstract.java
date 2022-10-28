package sql.temp;

import DB.domain.Hospital;
import DB.linereader.ReadLineContext;
import DB.parser.HospitalParser;

import java.sql.*;
import java.util.List;

public abstract class SqlQueryAbstract {
    public abstract Connection makeConnection() throws SQLException;

    public void insert() throws ClassNotFoundException, SQLException {
        Connection connection = makeConnection();
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
        Connection connection = makeConnection();

        Statement s = connection.createStatement();
        ResultSet resultSet = s.executeQuery("SELECT * FROM `Seoul-hospitals`.`seoul-hospitals-table`");

        resultSet.next();
        System.out.println(resultSet.getString("name"));

        s.close();
        connection.close();
    }
}
