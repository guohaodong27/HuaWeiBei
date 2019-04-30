package database;

import javax.persistence.*;

@Entity
@Table(name = "achieve", schema = "goodthing", catalog = "")
public class AchieveEntity {
    private int achieveId;
    private int userId;
    private String tags;
    private String favorite;
    private String clazz;
    private String url;
    private String text;
    private String markdown;

    @Id
    @Column(name = "achieveId")
    public int getAchieveId() {
        return achieveId;
    }

    public void setAchieveId(int achieveId) {
        this.achieveId = achieveId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "favorite")
    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Basic
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "markdown")
    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AchieveEntity that = (AchieveEntity) o;

        if (achieveId != that.achieveId) return false;
        if (userId != that.userId) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (favorite != null ? !favorite.equals(that.favorite) : that.favorite != null) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (markdown != null ? !markdown.equals(that.markdown) : that.markdown != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = achieveId;
        result = 31 * result + userId;
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (favorite != null ? favorite.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (markdown != null ? markdown.hashCode() : 0);
        return result;
    }
}
