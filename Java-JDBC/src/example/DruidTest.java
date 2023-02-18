package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查操作
 *
 */

public class DruidTest
    {
        /**
         * 查询所有
         * 1.sql：select * from tb_Brand
         * 2.参数：不需要
         * 3.结果：List<Brand>
         */
        @Test
        public void testSelectAll() throws Exception
            {
                //1.获取连接Connection对象
                //1.1加载配置文件
                Properties prop=new Properties();
                prop.load(new FileInputStream("src/druid.properties"));
                //1.2获取连接池对象
                DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
                //1.3获取数据库连接Connection
                Connection conn=dataSource.getConnection();

                //2.定义SQL
                String sql="select * from tb_Brand";

                //3.获取pstmt对象
                PreparedStatement pstmt=conn.prepareStatement(sql);

                //4.设置参数
                //该查询不需要

                //5.执行sql
                ResultSet rs=pstmt.executeQuery();

                //6.处理结果List<Brand>，封装Brand对象，装载List集合
                Brand brand=null;
                List<Brand> Brands=new ArrayList<>();
                while (rs.next())
                    {
                        //获取数据
                        int id=rs.getInt("id");
                        String brandName=rs.getString("brand_name");
                        String companyName=rs.getString("company_name");
                        int ordered=rs.getInt("ordered");
                        String description=rs.getString("description");
                        int status = rs.getInt("status");
                        //封装Brand对象
                        brand=new Brand();
                        brand.setId(id);
                        brand.setBrandName(brandName);
                        brand.setCompanyName(companyName);
                        brand.setOrdered(ordered);
                        brand.setDescription(description);
                        brand.setStatus(status);
                        //封装集合
                        Brands.add(brand);
                    }
                //打印出集合
                System.out.println(Brands);

                //7.释放资源
                rs.close();
                pstmt.close();
                conn.close();

            }
        /**
         * 添加数据
         * sql：insert into tb_brand(brand_name, company_name, ordered, description, status)values(?,?,?,?,?);
         * 参数：除id之外的全部参数信息
         * 结果：返回一个Boolean类型值（即true或者false）
         */
        @Test
        public void testAdd() throws Exception
            {
                //接收页面提交的参数
                String brandName="香飘飘";
                String companyName="香飘飘";
                int ordered=7;
                String description="绕地球一圈";
                int status=1;



                //1.获取Connection连接对象
                Properties prop=new Properties();
                prop.load(new FileInputStream("src/druid.properties"));
                DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);
                Connection conn=dataSource.getConnection();
                //2.sql
                String sql="insert into tb_brand(brand_name,company_name, ordered, description, status)\n" +
                        "values(?,?,?,?,?)";
                //3.获取pstmt对象
                PreparedStatement pstmt=conn.prepareStatement(sql);
                //4.设置参数
                pstmt.setString(1,brandName);
                pstmt.setString(2,companyName);
                pstmt.setInt(3,ordered);
                pstmt.setString(4,description);
                pstmt.setInt(5,status);
                //5.执行sql
                int count=pstmt.executeUpdate();//受影响的行数
                //6.处理结果
                System.out.println(count>0);
                //7.释放资源
                pstmt.close();
                conn.close();
            }
        /**
         * 修改数据
         * SQL：update tb_brand
         set brand_name=?,
         company_name=?,
         ordered=?,
         description=?,
         status=?
         where id=?
         * 参数：所有参数
         * 结果：返回一个Boolean类型值
         */
        @Test
        public void testUpdate()throws Exception
            {
                //接收页面提交的参数
                String brandName="香飘飘";
                String companyName="香飘飘公司";
                int ordered=9;
                String description="绕地球三圈";
                int status=1;
                int id=4;



                //1.获取Connection连接对象
                Properties prop=new Properties();
                prop.load(new FileInputStream("src/druid.properties"));
                DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);
                Connection conn=dataSource.getConnection();
                //2.sql
                String sql="update tb_brand \n" +
                        "        set brand_name=?,\n" +
                        "           company_name=?,\n" +
                        "           ordered=?,\n" +
                        "           description=?,\n" +
                        "           status=?\n" +
                        "        where id=?";
                //3.获取pstmt对象
                PreparedStatement pstmt=conn.prepareStatement(sql);
                //4.设置参数
                pstmt.setString(1,brandName);
                pstmt.setString(2,companyName);
                pstmt.setInt(3,ordered);
                pstmt.setString(4,description);
                pstmt.setInt(5,status);
                pstmt.setInt(6,id);
                //5.执行SQL
                int count=pstmt.executeUpdate();
                //6.处理数据
                System.out.println(count>0);
                //7.释放资源
                pstmt.close();
                conn.close();
            }
        /**
         * 删除数据
         * SQL：delete from tb_brand where id = ?
         * 参数：仅id
         * 结果：返回一个Boolean类型值
         */
        @Test
        public void testDelete()throws Exception
            {
                //接收页面信息
                int id=4;

                //1.获取Connection对象
                Properties prop=new Properties();
                prop.load(new FileInputStream("src/druid.properties"));
                DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);
                Connection conn=dataSource.getConnection();
                //2.sql
                String sql="delete from tb_brand where id=?";
                //3.获取pstmt对象
                PreparedStatement pstmt=conn.prepareStatement(sql);
                //4.设置参数
                pstmt.setInt(1,id);
                //5.执行SQL
                int count=pstmt.executeUpdate();
                //6.处理结果
                System.out.println(count>0);
                //7.释放资源
                pstmt.close();
                conn.close();
            }

    }
