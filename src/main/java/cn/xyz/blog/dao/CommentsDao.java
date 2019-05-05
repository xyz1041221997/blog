package cn.xyz.blog.dao;

import cn.xyz.blog.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsDao extends JpaRepository<Comments,Long> {

    public List<Comments> findCommentsByArticleIdOrderByCreateTime(Long articleId);
}
