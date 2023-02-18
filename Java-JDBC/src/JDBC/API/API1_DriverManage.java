/*
JDBC API详解
DriverManager
1.注册驱动
    ==提示：==
  MySQL 5之后的驱动包，可以省略注册驱动的步骤
  自动加载jar包中META-INF/services/java.sql.Driver文件
中的驱动类
2.获取数据库连接
  url：连接路径
      语法：jdbc:mysql://ip地址(域名):端口号/数据库名称?参数键值对1&参数键值对2…
      示例：jdbc:mysql://127.0.0.1:3306/db1
        ==细节：==
      如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：jdbc:mysql:///数据库名称?参数键值对
      配置 useSSL=false 参数，禁用安全连接方式，解决警告提示
 */
package JDBC.API;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class API1_DriverManage
{
    public static void main(String[] args) throws Exception
    {
        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        //String url="jdbc:mysql://localhost:3306/db1";
        //这一步可简化为：
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义SQL
        String sql="update account set money=3000 where id=1";
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
