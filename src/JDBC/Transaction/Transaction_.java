package JDBC.Transaction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Transaction_ {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String sql = "update actor set name=? where id = ?";
        String sql2 = "update actor set name=? where id = ?";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement preparedStatement;
        //开始事务
        try{
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Aze");
        preparedStatement.setInt(2, 1);
        preparedStatement.executeUpdate();
        //int i = 1/0;
        }catch (Exception e){
            System.out.println("程序出错，进行回滚");
            connection.rollback();
            e.printStackTrace();
        }
        preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setString(1,"zd");
        preparedStatement.setInt(2,2);
        preparedStatement.executeUpdate();
        //提交事务
        connection.commit();
        System.out.println("成功");
        connection.close();
        preparedStatement.close();
    }
}
