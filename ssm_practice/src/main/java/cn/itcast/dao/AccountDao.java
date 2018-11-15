package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 帐户dao接口
 */
public interface AccountDao {

    // 查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    // 保存帐户信息
    @Insert("insert into account values (#{id},#{name},#{money})")
    @SelectKey(keyProperty = "id",before = true, statement = "SELECT ACCOUNT_ID.nextval id from dual", resultType = Integer.class)
    public void saveAccount(Account account);

}
