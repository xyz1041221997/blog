package cn.xyz.blog.dao;


import cn.xyz.blog.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * JpaRepository<Diary,Long> 实体类 和主键类型
 */
public interface DiaryDao extends JpaRepository<Diary,Long> {
    /**
     * 通过时间查询日记集
     * @return
     */
   public List<Diary> getDiariesByCreateTime(Date createTime);

    /**
     * 修改日记内容
     * @param content
     * @param id
     * @return
     */
  @Modifying
  @Query(value = "update Diary set content = ?1 where id = ?2")
   public void updateDiary(String content,Long id);

    /**
     * 删除日记通过id
     * @return
     */
    @Override
  public void deleteById(Long id);
}
