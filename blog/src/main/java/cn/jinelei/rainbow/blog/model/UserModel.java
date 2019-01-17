package cn.jinelei.rainbow.blog.model;

import cn.jinelei.rainbow.blog.model.enumerate.GroupPrivilege;
import cn.jinelei.rainbow.blog.model.enumerate.UserPrivilege;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author zhenlei
 */
@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String username;
    @Column
    private String nickname;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private UserPrivilege userPrivilege;
    @Column
    private GroupPrivilege groupPrivilege;
    @Column
    @OneToMany(targetEntity = ArticleModel.class, cascade = CascadeType.REFRESH, mappedBy = "author")
    private List<ArticleModel> articles;
    @Column
    @OneToMany(targetEntity = CategoryModel.class, cascade = CascadeType.REFRESH, mappedBy = "categoryCreator")
    private List<CategoryModel> categories;
    @Column
    @OneToMany(targetEntity = TagModel.class, cascade = CascadeType.REFRESH, mappedBy = "tagCreator")
    private List<TagModel> tags;
    @Column
    @OneToMany(targetEntity = CommentModel.class, cascade = CascadeType.REFRESH, mappedBy = "commentator")
    private List<CommentModel> comments;

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", userPrivilege=" + userPrivilege +
                ", groupPrivilege=" + groupPrivilege +
                ", articles=" + articles +
                ", categories=" + categories +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }

    public boolean equalsWithId(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(username, userModel.username) &&
                Objects.equals(nickname, userModel.nickname) &&
                Objects.equals(phone, userModel.phone) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(province, userModel.province) &&
                Objects.equals(city, userModel.city) &&
                userPrivilege == userModel.userPrivilege &&
                groupPrivilege == userModel.groupPrivilege &&
                Objects.equals(articles, userModel.articles) &&
                Objects.equals(categories, userModel.categories) &&
                Objects.equals(tags, userModel.tags) &&
                Objects.equals(comments, userModel.comments);
    }

    public UserModel() {
    }

    public UserModel(String username, String nickname, String phone, String email, String province, String city, UserPrivilege userPrivilege, GroupPrivilege groupPrivilege, List<ArticleModel> articles, List<CategoryModel> categories, List<TagModel> tags, List<CommentModel> comments) {
        this.username = username;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.province = province;
        this.city = city;
        this.userPrivilege = userPrivilege;
        this.groupPrivilege = groupPrivilege;
        this.articles = articles;
        this.categories = categories;
        this.tags = tags;
        this.comments = comments;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserPrivilege getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(UserPrivilege userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public GroupPrivilege getGroupPrivilege() {
        return groupPrivilege;
    }

    public void setGroupPrivilege(GroupPrivilege groupPrivilege) {
        this.groupPrivilege = groupPrivilege;
    }

    public List<ArticleModel> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleModel> articles) {
        this.articles = articles;
    }

    public List<CategoryModel> getcategories() {
        return categories;
    }

    public void setcategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public List<TagModel> getTagList() {
        return tags;
    }

    public void setTagList(List<TagModel> tags) {
        this.tags = tags;
    }

    public List<CategoryModel> getCategoryList() {
        return categories;
    }

    public void setCategoryList(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public List<CommentModel> getCommentList() {
        return comments;
    }

    public void setCommentList(List<CommentModel> comments) {
        this.comments = comments;
    }
}
