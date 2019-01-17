package cn.jinelei.rainbow.blog.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author zhenlei
 */
@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "create_time")
    private Long createTime;
    @Column(name = "modify_time")
    private Long modifyTime;
    @Column(name = "access_time")
    private Long accessTime;
    @Column(name = "name")
    private String name;
    @Column(name = "summary")
    private String summary;
    @OneToMany(targetEntity = ArticleModel.class, mappedBy = "category")
    private List<ArticleModel> articles;
    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "categoryCreator")
    private UserModel categoryCreator;

    public boolean equalsWithoutId(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryModel that = (CategoryModel) o;
        return Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime) &&
                Objects.equals(accessTime, that.accessTime) &&
                Objects.equals(name, that.name) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(articles, that.articles) &&
                Objects.equals(categoryCreator, that.categoryCreator);
    }

    public CategoryModel() {
    }

    public CategoryModel(Long createTime, Long modifyTime, Long accessTime, String name, String summary, List<ArticleModel> articles, UserModel categoryCreator) {
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.accessTime = accessTime;
        this.name = name;
        this.summary = summary;
        this.articles = articles;
        this.categoryCreator = categoryCreator;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<ArticleModel> getArticleList() {
        return articles;
    }

    public void setArticleList(List<ArticleModel> articles) {
        this.articles = articles;
    }

    public UserModel getCategoryCreator() {
        return categoryCreator;
    }

    public void setCategoryCreator(UserModel categoryCreator) {
        this.categoryCreator = categoryCreator;
    }
}
