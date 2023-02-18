/*
JDBC API详解
Connection
  获取执行 SQL 的对象
    普通执行对象：
      Statement createStatement()
    预编译SQL的执行SQL执行对象：防止SQL注入
      preparedStatement preparedStatement(sql)
    执行存储过程的对象
      CallableStatement preparedCall(sql)
  管理事务
    开启事务
      setAutoCommit(boolean AutoCommit)
      参与autoCommit 表示是否自动提交事务，true表示自动提交事务，false表示手动提交事务。而开启事务需要将该参数设为为false。
    提交事务
      commit()
    回滚事务
      rollback()

    注意：选中一部分内容，按ctrl+alt+t可调出快捷方法使用try方法
 */
package JDBC.API;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class API2_Connection
{
    public static void main(String[] args) throws Exception
    {
        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义SQL
        String sql1="update account set money=3000 where id=1";
        String sql2="update account set money=3000 where id=2";
        //4.获取执行SQL的对象
        Statement stmt = conn.createStatement();
        try
        {
            //开启事务
            conn.setAutoCommit(false);

            //5.执行SQL
            int count1=stmt.executeUpdate(sql1);
            //6.处理结果
            System.out.println(count1);

            //此处加入一个错误
            //int a=3/0;

            //5.执行SQL
            int count2=stmt.executeUpdate(sql2);
            //6.处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();

        } catch (Exception e)
        {

            //回滚事务
            conn.rollback();

            throw new RuntimeException(e);
        }


        //7.释放资源
        stmt.close();
        conn.close();

    }
}
