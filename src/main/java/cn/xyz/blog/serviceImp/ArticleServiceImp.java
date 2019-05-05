package cn.xyz.blog.serviceImp;

import cn.xyz.blog.entity.Article;

public interface ArticleServiceImp {
    /**
     * 创建文章
     * @param artilce
     */
    void createArticle(Article artilce);

    /**
     * 找到一篇文章
     * @param id
     * @return
     */
    Article findOne(Long id);

    /**
     * 增加点击量
     * @param id
     */
    void addWatchSum(Long id);

    /**
     * 增加点赞数
     * @param id
     */
    void addSupportSum(Long id);

    /**
     * 增加留言量
     * @param id
     */
    void addMessageSum(Long id);

    /**
     * 修改文章
     * @param article
     */
    void updateArticle(Article article);
}
