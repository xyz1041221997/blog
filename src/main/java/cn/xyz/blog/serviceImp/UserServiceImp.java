package cn.xyz.blog.serviceImp;

import cn.xyz.blog.entity.User;
import org.springframework.data.domain.Pageable;

/**
 * 用户的接口
 */
public interface UserServiceImp {

    /**
     * 登录用户
     * @param user
     * @return
     */
    User loginUser(User user);

    /**
     * 注册用户
     * @param user
     */
    void createUser(User user);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
     User updateUser(User user);


}
