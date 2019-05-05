package cn.xyz.blog.entity;

import javax.persistence.*;

@Entity
@Table
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Long articleSum;

    private Long userId;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", articleSum=" + articleSum +
                ", userId=" + userId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getArticleSum() {
        return articleSum;
    }

    public void setArticleSum(Long articleSum) {
        this.articleSum = articleSum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
