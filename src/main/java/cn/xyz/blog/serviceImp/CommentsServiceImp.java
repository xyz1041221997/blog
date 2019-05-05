package cn.xyz.blog.serviceImp;

import cn.xyz.blog.entity.Comments;

import java.util.List;

public interface CommentsServiceImp {

    public void createComments(Comments comments);

    public List<Comments> findComments(Long articleId);

}
