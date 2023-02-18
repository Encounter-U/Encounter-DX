package JDBC.API;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class API5_PreparedStatement_SQL注入演示
    {
        @Test
        public void testLogin() throws Exception
            {
                //2.获取链接对象
                String url="jdbc:mysql:///db1";
                String username="Encounter";
                String password="20020628";
                Connection conn= java.sql.DriverManager.getConnection(url,username,password);

                //接收用户输入 用户名和密码
                String name="lumingfei";
                String pwd="123";

                String sql="select * from tb_user where username='"+name+"' and password='"+pwd+"'";

                //获取Statement对象
                Statement stmt=conn.createStatement();


                //执行sql
                ResultSet rs=stmt.executeQuery(sql);

                //判断是否登录成功
                if(rs.next())
                    {
                        System.out.println("登陆成功");
                    }
                else
                    {
                        System.out.println("登陆失败");
                    }



                /*
                //7.释放资源
                rs.close();
                stmt.close();
                conn.close();
                 */
            }

        /**
         * 演示SQL注入
         * @throws Exception
         */
        @Test
        public void testLogin_Inject() throws Exception
            {
                //2.获取链接对象
                String url="jdbc:mysql:///db1";
                String username="Encounter";
                String password="20020628";
                Connection conn= java.sql.DriverManager.getConnection(url,username,password);

                //接收用户输入 用户名和密码
                String name="chuzihang";
                String pwd="'or'1'='1";

                String sql="select * from tb_user where username='"+name+"' and password='"+pwd+"'";

                //打印出此时的sql语句
                System.out.println(sql);

                //获取Statement对象
                Statement stmt=conn.createStatement();


                //执行sql
                ResultSet rs=stmt.executeQuery(sql);

                //判断是否登录成功
                if(rs.next())
                    {
                        System.out.println("登陆成功");
                    }
                else
                    {
                        System.out.println("登陆失败");
                    }



                /*
                //7.释放资源
                rs.close();
                stmt.close();
                conn.close();
                 */
            }

    }
