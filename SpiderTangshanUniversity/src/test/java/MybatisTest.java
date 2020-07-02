import Dao.Dao;
import mapper.LinkMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Link;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-14:53
 */


public class MybatisTest {


    @Test
    public void test() {
        //定义读取文件名
                 String resources = "mybatis-config.xml";
                 //创建流
                 Reader reader=null;
                 try {
                         //读取mybatis-config.xml文件到reader对象中
                         reader= Resources.getResourceAsReader(resources);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 //初始化mybatis,创建SqlSessionFactory类的实例
                 SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
                 //创建session实例
                 SqlSession session=sqlMapper.openSession();
                 //传入参数查询，返回结果
                 int insertLink = session.insert("insertLink", "www.baidu.com");
                 System.out.println(insertLink);
        //输出结果
//                 System.out.println(user.getUname());
                 //关闭session
                 session.close();
    }

    // 接口方式
    @Test
    public void test01() throws IOException {
        // 全局配置文件
        String globalConfigFile = "mybatis-config.xml";

        // 1. 使用配置文件构建SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream(globalConfigFile));

        // 2. 获取sqlSession,相当于数据库连接, sqlSession 是非线程安全的, 所以每次数据库操作都需要重新获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口对应的代理对象
        LinkMapper linkmapper = sqlSession.getMapper(LinkMapper.class);
//        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Link link = new Link("www.baidu.com");
        // 4. 执行mapper 对应的方法
        linkmapper.insertLink("www.baidu.com");
//        EmployeePO employeePO = employeeMapper.findById(1L);

        // 5. 关闭连接
        sqlSession.close();

//        System.out.println(employeePO);
    }

    @Test
    public void test3() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("linkname","www.baidu.com");
        int t_link = Dao.insertObj("t_link", map);
        System.out.println(t_link);


    }



}
