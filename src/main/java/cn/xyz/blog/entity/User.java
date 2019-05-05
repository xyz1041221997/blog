package cn.xyz.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 用户实体类
 */
@Entity
public class User {
    private static final long serialVersionUID = 1L;
//    @GenericGenerator(name="suiji",strategy = "uuid")
    //用户id唯一标示
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //自增属性
    @Id
    private Long id;

    @NotEmpty(message = "姓名不能为空")
    @Size(min=2, max=20)
    @Column(nullable = false, length = 20) // 映射为字段，值不能为空
    private String name;

    /**账号,认证唯一标*/
    @NotEmpty(message = "账号不能为空")
    @Size(min = 3,max = 20)
    @Column(nullable = false,length = 20,unique = true)
    private String username;
    /**用户密码*/
    @NotEmpty(message = "密码不能为空")
    @Size(max=100)
    @Column(length = 100)
    private String password;
    //用户邮箱
    @NotEmpty(message = "邮箱不能为空")
    @Size(max=50)
    @Email(message= "邮箱格式不对" )
    @Column(nullable = false, length = 50, unique = true)
    private String mail;

    private String about;                      //用户关于自己

    private String w3c;                        //用户网站
    @Column(length = 200)
    private String headPic;                   //用户头像

    //用户浏览次数
    private Long seeSum;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", about='" + about + '\'' +
                ", w3c='" + w3c + '\'' +
                ", headPic='" + headPic + '\'' +
                ", seeSum=" + seeSum +
                '}';
    }

    public Long getSeeSum() {
        return seeSum;
    }

    public void setSeeSum(Long seeSum) {
        this.seeSum = seeSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getW3c() {
        return w3c;
    }

    public void setW3c(String w3c) {
        this.w3c = w3c;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

}
