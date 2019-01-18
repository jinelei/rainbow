package cn.jinelei.rainbow.blog.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

/**
 * @author zhenlei
 */
@Entity
@Table(name = "tag")
@JacksonXmlRootElement(localName = "tag")
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    @XmlElement
    private Integer tagId;
    @XmlElement
    @Column(name = "create_time")
    private Long createTime;
    @XmlElement
    @Column(name = "modify_time")
    private Long modifyTime;
    @XmlElement
    @Column(name = "access_time")
    private Long accessTime;
    @XmlElement
    @Column(name = "name")
    private String name;
    @XmlElement
    @Column(name = "summarty")
    private String summary;
    @XmlElement
    @ManyToMany(targetEntity = ArticleModel.class, mappedBy = "tags")
    private List<ArticleModel> articles;
    @XmlElement
    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "tagCreator")
    private UserModel tagCreator;

    @Override
    public String toString() {
        return "TagModel{" +
                "tagId=" + tagId +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", accessTime=" + accessTime +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", articles=" + articles +
                ", tagCreator=" + tagCreator +
                '}';
    }

    public boolean equalsWithoutId(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagModel tagModel = (TagModel) o;
        return Objects.equals(createTime, tagModel.createTime) &&
                Objects.equals(modifyTime, tagModel.modifyTime) &&
                Objects.equals(accessTime, tagModel.accessTime) &&
                Objects.equals(name, tagModel.name) &&
                Objects.equals(summary, tagModel.summary) &&
                Objects.equals(articles, tagModel.articles) &&
                Objects.equals(tagCreator, tagModel.tagCreator);
    }

    public TagModel() {
    }

    public TagModel(Long createTime, Long modifyTime, Long accessTime, String name, String summary, List<ArticleModel> articles, UserModel tagCreator) {
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.accessTime = accessTime;
        this.name = name;
        this.summary = summary;
        this.articles = articles;
        this.tagCreator = tagCreator;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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

    public UserModel getTagCreator() {
        return tagCreator;
    }

    public void setTagCreator(UserModel tagCreator) {
        this.tagCreator = tagCreator;
    }
}
