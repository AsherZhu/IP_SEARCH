package demo.util;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by zhushuai.net@gmail.com
 * 06/10/2017 08:50.
 * https://github.com/ZhuShuai1992
 */
public class Db {
    private static final String URL = "jdbc:mysql:///?user=root&password=system";

    public static Connection getConnection() {
        try {
            // 1、加载JDBC数据库驱动
            new Driver();
            // 2 、建立数据库连接
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
