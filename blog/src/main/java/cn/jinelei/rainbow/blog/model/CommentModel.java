package cn.jinelei.rainbow.blog.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author zhenlei
 */
@Entity
@Table(name = "comment")
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "create_time")
    private Long createTime;
    @Column(name = "modify_time")
    private Long modifyTime;
    @Column(name = "access_time")
    private Long accessTime;
    @Column(name = "content")
    private String content;
    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "commentator")
    private UserModel commentator;
    @ManyToOne(targetEntity = ArticleModel.class)
    @JoinColumn(name = "article")
    private ArticleModel article;

    public CommentModel() {
    }

    public CommentModel(Long createTime, Long modifyTime, Long accessTime, String content, UserModel commentator, ArticleModel article) {

        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.accessTime = accessTime;
        this.content = content;
        this.commentator = commentator;
        this.article = article;
    }

    public Integer getCommentId() {

        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public UserModel getCommentator() {
        return commentator;
    }

    public void setCommentator(UserModel commentator) {
        this.commentator = commentator;
    }

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }
}
