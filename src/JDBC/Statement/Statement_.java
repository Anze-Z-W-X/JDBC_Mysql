package JDBC.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statement_ {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/learn";
        String user = "root";
        String password = "200312Zwx";
        String sql = "update actor set name='妹扣' where id=1";
        Connection connection = DriverManager.getConnection(url, user, password);
        java.sql.Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int anInt = resultSet.getInt(1);
            String s = resultSet.getString(2);
        }
        statement.close();
        connection.close();
    }
}
