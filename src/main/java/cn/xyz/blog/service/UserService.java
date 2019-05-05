package cn.xyz.blog.service;

import cn.xyz.blog.dao.UserDao;
import cn.xyz.blog.entity.User;
import cn.xyz.blog.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserDao userDao;

    /**
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
   public User loginUser(User user){
     return  userDao.getByUsernameAndPassword(user.getUsername(),user.getPassword());
   }

    @Transactional(rollbackOn = Exception.class)
    @Override
   public void createUser(User user){
        user.setSeeSum(0L);
       userDao.save(user);
   }

   @Transactional(rollbackOn = Exception.class)
   @Override
   public User updateUser(User user){
       return  userDao.save(user);
   }

    /**
     * 增加浏览次数
     * @param id
     */
   public void addSeeSum(Long id){
        userDao.addSeeSum(id);
   }

   public boolean reUserName(String username){
     User user = userDao.findUserByUsername(username);
       System.out.println(user);
     if(user != null){
         return false;
     }else{
         return true;
     }
   }
   public boolean reName(String name) {
       User user = userDao.findUserByName(name);
       if(user != null){
           return false;
       }else {
           return true;
       }
   }

   public boolean reMail(String mail){
       User user = userDao.findUserByMail(mail);
       System.out.println(user);
       if(user != null){
           return false;
       }else{
           return true;
       }
   }
}
