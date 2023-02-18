package JDBC.API;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * API详解：PreparedStatement
 * 获取 PreparedStatement 对象
 *   // SQL语句中的参数值，使用？占位符替代
 *   String sql = "select * from user where username =? and password = ?";
 *   // 通过Connection对象获取，并传入对应的sql语句
 *   PreparedStatement pstmt =conn.prepareStatement(sql);
 * 设置参数值
 *   PreparedStatement对象：setXxx(参数1，参数2)：给 ? 赋值
 *   Xxx：数据类型 ； 如 setInt (参数1，参数2)
 *  参数：
 *    参数1： ？的位置编号，从1 开始
 *    参数2： ？的值
 * 执行SQL语句
 *   executeUpdate(); 执行DDL语句和DML语句
 *   executeQuery(); 执行DQL语句
 *  ==注意：==
 *   调用这两个方法时不需要传递SQL语句，因为获取SQL语句执行对象时已经对SQL语句进行预编译了。
 */

public class API5_PreparedStatement
    {
        @Test
        public void testPreparedStatement() throws Exception
            {
                //2.获取链接对象
                String url="jdbc:mysql:///db1";
                String username="Encounter";
                String password="20020628";
                Connection conn= java.sql.DriverManager.getConnection(url,username,password);

                //接收用户输入 用户名和密码
                String name="lumingfei";
                String pwd="123";
                //此时输错或者SQL注入就无法登录成功
                //Strin pwd="'or'1'='1'";

                //定义SQL
                String sql="select * from tb_user where username=? and password=?";

                //获取Statement对象
                PreparedStatement pstmt=conn.prepareStatement(sql);

                //设置？的值
                pstmt.setString(1,name);
                pstmt.setString(2,pwd);

                //执行sql
                ResultSet rs=pstmt.executeQuery();


                //判断是否登录成功
                if(rs.next())
                    {
                        System.out.println("登陆成功");
                    }
                else
                    {
                        System.out.println("登陆失败");
                    }


                //7.释放资源
                rs.close();
                pstmt.close();
                conn.close();

            }


    }
