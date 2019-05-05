package cn.xyz.blog.dao;

import cn.xyz.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Long> {
    /**'
     * 查找一篇文章
     * @param id
     * @return
     */
     Article findArticleById(Long id);

    /**
     * 增加流量量
      * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update Article set watchSum = watchSum + 1 where id = ?1")
    void addWatchSum(Long id);

    /**
     * 增加点赞数
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update Article set supportSum = supportSum + 1 where id = ?1")
    void addSupportSum(Long id);

    /**
     * 增加留言量
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update Article set  messageSum = messageSum + 1 where id = ?1")
    void addMessageSum(Long id);

    @Modifying
    @Query(value = "select * from Article ORDER BY watch_sum desc LIMIT 7",nativeQuery = true)
    List<Article> findTopArticle();

    /**
     * 寻找浏览量最多的
     * @return
     */

    @Query(value = "select * from Article ORDER BY watch_sum desc LIMIT 1",nativeQuery = true)
    Article findMostWatchArticle();

    /**
     * 寻找点赞最多的
     * @return
     */

    @Query(value = "select * from Article ORDER BY support_sum desc LIMIT 1",nativeQuery = true)
    Article findMostSupportArticle();

    /**
     * 寻找点赞最多的
     * @return
     */

    @Query(value = "select * from Article ORDER BY message_sum desc LIMIT 1",nativeQuery = true)
    Article findMostMessageArticle();
}
