package cn.xyz.blog.service;

import cn.xyz.blog.dao.CommentsDao;
import cn.xyz.blog.entity.Comments;
import cn.xyz.blog.serviceImp.CommentsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsService implements CommentsServiceImp {
    @Autowired
    CommentsDao commentsDao;

    @Override
    public void createComments(Comments comment) {
       commentsDao.save(comment);
    }

    @Override
    public List<Comments> findComments(Long articleId) {
        List<Comments> comments = commentsDao.findCommentsByArticleIdOrderByCreateTime(articleId);
        return comments;
    }
}
