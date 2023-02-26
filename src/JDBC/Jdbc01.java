package JDBC;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作：在项目下建立libs文件夹，放入mysql-connector-j-8.0.31.jar,再右键选中add as library

        //1.注册驱动
        Driver driver = new Driver();   //创建一个Driver对象
        //2.得到连接
        //(1)jdbc:mysql://是规定好的协议，通过jdbc连接到mysql
        //(2)localhost 主机，也可以是IP地址
        //(3)3306表示MySQL监听的端口
        //(4)learn是数据库名,表示连接到Mysql的dbms的哪个数据库
        //(5)mysql的连接本质就是前面的socket连接
        String url = "jdbc:mysql://localhost:3306/learn";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        //说明:user和password是规定好的，后面的根据实际更改
        properties.setProperty("user","root");//用户
        properties.setProperty("password","200312Zwx");//密码
        //connect就相当于一个网络连接
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        String sql = "delete from actor where id=3";
        //statement用于执行静态的sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//如果是dml语句，返回的是影响的行数
        System.out.println(rows>0?"成功":"失败");
        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}
