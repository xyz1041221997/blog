package cn.xyz.blog.dao;

import cn.xyz.blog.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeDao extends JpaRepository<Type,Long> {

    void deleteTypeById(Long id);

    /**
     * 通过用户id查询 用户的文章分类
     * @return
     */
    List<Type> findTypesByUserId(Long userId);


}
