package sql.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker<T> {
    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
