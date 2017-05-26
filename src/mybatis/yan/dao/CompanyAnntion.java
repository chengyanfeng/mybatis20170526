package mybatis.yan.dao;

import mybatis.cheng.beans.Company;
import org.apache.ibatis.annotations.Select;

import javax.xml.ws.ServiceMode;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
public interface CompanyAnntion {
    //这个注解相当于绑定一个mapperxml
    @Select("select * from company where id=#{id}")
    public Company getCompanybyId(int id);
}
