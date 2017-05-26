package mybatis.cheng.dao;

import mybatis.cheng.beans.Company;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
public interface CompanyMapper {



    public Company getCompByID(int i);
    //返回long
    public long insertCompany(Company company);
    //获取自增的id,但是必须是对象
    public void insertCompayAutoID(Company company);
    //删除返回的是boolean类型
    public boolean delectCompany(int id);
    //long 返回的是数字类型
    public long  updateCompany (Company company);
    //6.多个参数时候@param来映射#{name}，#{price}
        //因为mabatis会把多个参数封装成一个map，而map的key值是param1,param2....我们需要用@param来指定map的key的名字
    public long insertCompanyParam(@Param("name")String name,@Param("price")int price);
    //7.我们直接封装成一个map类型这样的话，就不用@Param注解了。直接map的key 值与#{name} 保持一致
    public boolean insertCompanyMap(Map<String,Object> map);
        //8.查询list
    public  List<Company> selectCompanyList(String name);
    //9.返回的参数封装成map
    public  Map<String,Object> selectCompanyMap(int id);
    //10.返回一个对象map,指定列为key
    @MapKey("id")
    public Map<String,Object> selectMapCompany(String name);

    //11.当驼峰命名法关闭的时候，用自定义的map
     public Company selectMyMapCompany(int id);

    //12.关联查询
    public Company selectMyMapCompanyAndCar(int id);
    //12.关联查询
    public Company selectMyMapCompanyAndCar2(int id);
    //13.关联查询,多个
    public Company selectMyMapCompanyAndCarList(int id);
}
