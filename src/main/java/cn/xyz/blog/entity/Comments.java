package cn.xyz.blog.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String content;

     private Instant createTime;

     private Long articleId;

     private Long userId;

     private String userName;

     private Long toCommentId;
    /**
     * 评论的类型,1 直接评论   2 回复评论
     */
     private String type;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", toCommentId=" + toCommentId +
                ", type='" + type + '\'' +
                '}';
    }

     public Long getArticleId() {
          return articleId;
     }

     public void setArticleId(Long articleId) {
          this.articleId = articleId;
     }
     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getContent() {
          return content;
     }

     public void setContent(String content) {
          this.content = content;
     }

     public Instant getCreateTime() {
          return createTime;
     }

     public void setCreateTime(Instant createTime) {
          this.createTime = createTime;
     }

     public Long getUserId() {
          return userId;
     }

     public void setUserId(Long userId) {
          this.userId = userId;
     }

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

    public Long getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }

    public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }
}
