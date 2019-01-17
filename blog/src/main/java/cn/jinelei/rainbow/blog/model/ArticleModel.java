package cn.jinelei.rainbow.blog.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author zhenlei
 */
@Entity
@Table(name = "article")
public class ArticleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleId;
    @Column(name = "create_time")
    private Long createTime;
    @Column(name = "modify_time")
    private Long modifyTime;
    @Column(name = "access_time")
    private Long accessTime;
    @Column(name = "content")
    private String content;
    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "author")
    private UserModel author;
    @ManyToOne(targetEntity = CategoryModel.class)
    @JoinColumn(name = "category")
    private CategoryModel category;
    @ManyToMany
    @JoinTable(name = "article_tag",
            joinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "tag_id")})
    private List<TagModel> tags;
    @Column
    @OneToMany(targetEntity = CommentModel.class, cascade = CascadeType.REFRESH, mappedBy = "article")
    private List<CommentModel> comments;

    public boolean equalsWithoutId(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArticleModel that = (ArticleModel) o;
        return Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime) &&
                Objects.equals(accessTime, that.accessTime) &&
                Objects.equals(content, that.content) &&
                Objects.equals(author, that.author) &&
                Objects.equals(category, that.category) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "articleId=" + articleId +
                ", createTime=" + createTime + ", modifyTime=" + modifyTime +
                ", accessTime=" + accessTime +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }

    public ArticleModel() {
    }

    public ArticleModel(Long createTime, Long modifyTime, Long accessTime, String content, UserModel author, CategoryModel category, List<TagModel> tags, List<CommentModel> comments) {

        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.accessTime = accessTime;
        this.content = content;
        this.author = author;
        this.category = category;
        this.tags = tags;
        this.comments = comments;
    }

    public Integer getArticleId() {

        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public List<TagModel> getTagList() {
        return tags;
    }

    public void setTagList(List<TagModel> tags) {
        this.tags = tags;
    }

    public List<CommentModel> getCommentList() {
        return comments;
    }

    public void setCommentList(List<CommentModel> comments) {
        this.comments = comments;
    }
}

