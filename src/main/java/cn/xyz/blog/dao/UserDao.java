package cn.xyz.blog.dao;

import cn.xyz.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User,Long> {

    /**
     * 登入用户
     * @param username
     * @param password
     * @return
     */
     User getByUsernameAndPassword(String username,String password);

    /**
     * 用户登录次数
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "update User set seeSum = seeSum + 1 where id = ?1")
    void addSeeSum(Long id);

    /**
     * 查询邮箱,有户名 账户是否重复
     * @param Username
     * @return
     */
    @Query(value = "select * from User u where u.username = ?1",nativeQuery = true)
    User findUserByUsername(String Username);

    @Query(value = "select * from User u where u.mail = ?1",nativeQuery = true)
    User findUserByMail(String mail);

    @Query(value = "select * from User u where u.name = ?1",nativeQuery = true)
    User findUserByName(String name);

}
