package JDBC;

import com.mysql.cj.jdbc.Driver;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/learn";
        String sql = "update actor set name='妹扣' where id=1";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","200312Zwx");
        Connection connect = driver.connect(url, info);
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i>0?"y":"f");
        connect.close();
        statement.close();
    }
}
