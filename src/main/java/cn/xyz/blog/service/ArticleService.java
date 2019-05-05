package cn.xyz.blog.service;

import cn.xyz.blog.dao.ArticleDao;
import cn.xyz.blog.entity.Article;
import cn.xyz.blog.serviceImp.ArticleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceImp {

    @Autowired
    ArticleDao articleDao;

    @Override
    public void createArticle(Article artilce) {
        articleDao.save(artilce);
    }
    public List<Article> findAllArticles(Sort sort){
       List<Article> articles =  articleDao.findAll(sort);
       return articles;
    }
    @Override
    public Article findOne(Long id) {
        return   articleDao.findArticleById(id);
    }

    @Override
    public void addWatchSum(Long id) {
       articleDao.addWatchSum(id);
    }

    @Override
    public void addSupportSum(Long id) {
        articleDao.addSupportSum(id);
    }

    @Override
    public void addMessageSum(Long id) {
        articleDao.addMessageSum(id);
    }

    @Override
    public void updateArticle(Article article) {

    }

    public List<Article> findTopFive(){
       return articleDao.findTopArticle();
    }

    public Article findMostWatchArticle(){
        return articleDao.findMostWatchArticle();
    }

    public Article findMostSupportArticle(){
        return articleDao.findMostSupportArticle();
    }

    public Article findMostMessageArticle(){
        return articleDao.findMostMessageArticle();
    }
}
