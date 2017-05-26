package mybatis.yan.mian;

import mybatis.cheng.beans.Company;
import mybatis.cheng.dao.CompanyMapper;
import mybatis.yan.dao.CompanyAnntion;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/25 0025.
 */
public class test {

    @Test//1.单独测试mapper.xml文件
    public void test1() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.配置文件的空间名，加方法
        Company o = sqlSession.selectOne("mybatis.cheng.beans.chengyaneng.getCompanyByid", 1);
        System.out.print(o.toString());
}

    @Test//2.单独测试接口CompanyAnnoution.class
    public void test2() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
            //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        CompanyAnntion mapper = sqlSession.getMapper(CompanyAnntion.class);
        Company companybyId = mapper.getCompanybyId(1);

        System.out.print(companybyId.toString());
    }
    @Test//3.测试Mapper与接口CompanyMapper.class绑定
    public void test3() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        Company companybyId = mapper.getCompByID(1);

        System.out.print(companybyId.toString());
    }

    @Test//4.测试增删改的返回值，boolean，long，和返回数据库自增的id
    public void test4() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
       try {
           CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
           //创建一个新的对象
           /*Company company = new Company("chengyanfeng20170525", 3242);
           //插入返回一个long类型
           long l = mapper.insertCompany(company);
           System.out.print(l);
           //获取自增的id,会自己返回给最初的company
           mapper.insertCompayAutoID(company);
           System.out.print(company.toString());*/
           Company company = new Company("chengyanfeng20170525", 3242,1);
        //测试update
           long l1 = mapper.updateCompany(company);
           System.out.print(l1);
            //delect
           boolean b = mapper.delectCompany(39);
           System.out.print(b);
           sqlSession.commit();

       }
       catch (Exception e){

       }finally {
           sqlSession.close();
       }

    }

    @Test//5.测试增删改的返回值，boolean，long，和返回数据库自增的id
    public void test5() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
            //创建一个新的对象
            Company company = new Company("chengyanfeng20170525", 3242);
            //插入返回一个long类型
            long l = mapper.insertCompany(company);
            System.out.print(l);
            //获取自增的id,会自己返回给最初的company
            mapper.insertCompayAutoID(company);
            System.out.print(company.toString());
            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }

    @Test//6.测试@param 绑定参数与自动封装的map的key值
    public void test6() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);

            long l = mapper.insertCompanyParam("chengyanfeng@param", 43534);

            System.out.print(l);
            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }


    @Test//7.测试自己直接封装成map.key与传入的#{name}
    public void test7() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
            Map<String,Object> map=new HashMap<>();
            map.put("name","chengyanfeng");
            map.put("price",2);
            boolean b = mapper.insertCompanyMap(map);
             System.out.print(b);
            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }

    @Test//8.测试查询list
    public void test8() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);


            List<Company> companyList1 = mapper.selectCompanyList("%c%");

            for(Company company: companyList1){
              int id=  company.getId();
                System.out.print(id);
            }


            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }
    @Test//9.返回一个map,是一个对象中参数返回一个以列名key ,值为value
    public void test9() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);


            Map<String, Object> stringObjectMap = mapper.selectCompanyMap(1);



            System.out.print(stringObjectMap.toString());



            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }

    @Test//10.返回一个company 的map集合，key 为指定的列明为value
      public void test10() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);


            Map<String, Object> stringObjectMap1 = mapper.selectMapCompany("%c%");




            System.out.print(stringObjectMap1.toString());



            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }

    @Test//11.返回一个自己定义的returnMap 集合。用
    public void test11() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);


            Company company = mapper.selectMyMapCompany(1);
            System.out.print(company.toString());



            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }
    @Test//12.返回关联的returnMap,两个表相互关联，返回单个关联
    public void test12() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
            //Company company = mapper.selectMyMapCompanyAndCar(1);
            Company company = mapper.selectMyMapCompanyAndCar2(1);
            System.out.print(company.toString());
            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }
    @Test//13.返回关联的returnMap,两个表相互关联，返回多个关联
    public void test13() throws  Exception{
        //1.获取Sqlsession
        SqlSessionFactory sqlSessionFactory=getSqlSessionFacotry();
        //2.开启opensession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取CompanyMapper.class这个接口
        //由于接口必须要有实现类，才能创建对象，我们没有实现类，框架自动帮我们创建一个实现类。
        try {
            CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
            Company company = mapper.selectMyMapCompanyAndCarList(1);

            System.out.print(company.toString());
            sqlSession.commit();

        }
        catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }
    //获取sqlSessionFactory
    public SqlSessionFactory getSqlSessionFacotry() throws  Exception{
        //1.根据配置文件获取sqlSession
        //创建sqlsessionFactroy

            String res="mybtis.xml";
            InputStream inputStream = Resources.getResourceAsStream(res);
            return new SqlSessionFactoryBuilder().build(inputStream);
        }


}
