package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql://localhost:3306/db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义SQL
        String sql="update account set money=2000 where id=1";
        //4.获取执行SQL的对象
        Statement stmt=conn.createStatement();
        //5.执行SQL
        int count=stmt.executeUpdate(sql);
        //6.处理结果
        System.out.println(count);
        //7.释放资源
        stmt.close();
        conn.close();

    }
}
