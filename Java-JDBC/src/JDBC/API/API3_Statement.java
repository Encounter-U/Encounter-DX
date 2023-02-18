package JDBC.API;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class API3_Statement
{
    @Test
    public void DMLTest() throws Exception
    {
        /**
         * 执行DML语句
         * @throws Exception
         */
        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义SQL
        String sql="update account set money=3000 where id=1";

        /**
         * 因为表中没有第五行数据，所以此时受影响行数为零
         */
        //String sql="update account set money=3000 where id=5";

        //4.获取执行SQL的对象
        Statement stmt = conn.createStatement();
        //5.执行SQL
        int count=stmt.executeUpdate(sql);//执行完DML语句后受影响的行数
        //6.处理结果
        //System.out.println(count);
        if (count>0)
        {
            System.out.println("修改成功");
        }
        else
            System.out.println("修改失败");
        //7.释放资源
        stmt.close();
        conn.close();
    }
    @Test
    public void DDLTest() throws Exception
    {

        /**
         * 执行DDL语句
         * @throws Exception
         */
        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义SQL
        //String sql="create database db2";
        String sql="drop database if exists db2";//此时返回受影响的行数为零，不报错即可
        //4.获取执行SQL的对象
        Statement stmt = conn.createStatement();
        //5.执行SQL
        int count=stmt.executeUpdate(sql);//执行完DDL语句后受影响的行数,可能为零
        //6.处理结果
        System.out.println(count);
                /*
                if (count>0)
                    {
                        System.out.println("创建成功");
                    }
                else
                    System.out.println("创建失败");

                 */
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
