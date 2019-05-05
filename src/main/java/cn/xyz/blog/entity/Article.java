package cn.xyz.blog.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private String content;

    private String userName;

    private Long userId;

    private Long watchSum;

    private Long supportSum;

    private Long messageSum;

    private String type;
    /**
     * 简介
     */
    private String intro;

    private Instant createTime;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", watchSum=" + watchSum +
                ", supportSum=" + supportSum +
                ", messageSum=" + messageSum +
                ", type='" + type + '\'' +
                ", intro='" + intro + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWatchSum() {
        return watchSum;
    }

    public void setWatchSum(Long watchSum) {
        this.watchSum = watchSum;
    }

    public Long getSupportSum() {
        return supportSum;
    }

    public void setSupportSum(Long supportSum) {
        this.supportSum = supportSum;
    }

    public Long getMessageSum() {
        return messageSum;
    }

    public void setMessageSum(Long messageSum) {
        this.messageSum = messageSum;
    }

}
