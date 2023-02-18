/**
 * ResuleSet
 * boolean next()
 * 将光标从当前位置向前移动一行
 * 判断当前行是否为有效行
 *
 * 方法返回值说明：
 * true ： 有效航，当前行有数据
 * false ： 无效行，当前行没有数据
 *
 * xxx getXxx(参数)：获取数据
 * xxx : 数据类型；如： int getInt(参数) ；String getString(参数)
 *
 * 参数
 * int类型的参数：列的编号，从1开始
 * String类型的参数： 列的名称
 */
package JDBC.API;

import org.junit.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class API4_ResultSet
{
    /**
     * 执行DQL语句
     * @throws Exception
     */
    @Test
    public void DQLTest1() throws Exception
    {

        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);

        //3.定义sql
        String sql="select * from account";
        //4.获取Statement对象
        Statement smtm=conn.createStatement();
        //5.执行SQL
        ResultSet rs=smtm.executeQuery(sql);
        //6.处理结果，遍历rs中所有数据
        //6.1光标移动至下一行，并判断当前行是否有数据
        while (rs.next())
        {
            //6.2获取数据
                        /*
                        int id=rs.getInt(1);
                        String name=rs.getString(2);
                        double money=rs.getDouble(3);

                         */

            //除可使用编号外，也可使用对应列名，注意加双引号
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("-----------------");

        }
        //7.释放资源
        rs.close();
        smtm.close();
        conn.close();
    }


    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     * 1.定义实体类Account
     * 2.查询数据，封装到Account对象中
     * 3.将Account对象存入ArrayList中
     * @throws Exception
     */
    @Test
    public void DQLTest2() throws Exception
    {

        //1.注册驱动,MySQL5.0之后这一步可省略
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接对象
        String url="jdbc:mysql:///db1";
        String username="Encounter";
        String password="20020628";
        Connection conn=DriverManager.getConnection(url,username,password);

        //3.定义sql
        String sql="select * from account";
        //4.获取Statement对象
        Statement smtm=conn.createStatement();
        //5.执行SQL
        ResultSet rs=smtm.executeQuery(sql);

        //创建集合
        List<Account> List=new ArrayList<>();


        //6.处理结果，遍历rs中所有数据
        //6.1光标移动至下一行，并判断当前行是否有数据
        while (rs.next())
        {
            Account account=new Account();

            //6.2获取数据 getXxx()
            //除可使用编号外，也可使用对应列名，注意加双引号
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");

            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            //存入集合
            List.add(account);

        }

        System.out.println(List);
        //7.释放资源
        rs.close();
        smtm.close();
        conn.close();
    }
}
