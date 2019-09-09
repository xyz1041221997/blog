package cn.xyz.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;


@Entity
@Table
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "内容不能为空")
    private String content;

    private String year;  //年份

    private Instant createTime;   //创建时间

    private String title;    //标题

    private int publicz;   //是否公开

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", year='" + year + '\'' +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", publicz=" + publicz +
                ", userId=" + userId +
                ", uname='" + uname + '\'' +
                '}';
    }

    public int getPublicz() {
        return publicz;
    }

    public void setPublicz(int publicz) {
        this.publicz = publicz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**用户id*/
    private Long userId;

    /** 用户姓名*/
    private String uname;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
