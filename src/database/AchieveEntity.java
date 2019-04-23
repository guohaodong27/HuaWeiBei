package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "achieve", schema = "goodthing", catalog = "")
public class AchieveEntity {
    private int achieveId;
    private int userId;
    private String tags;
    private String favorite;
    private String clazz;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchieveEntity that = (AchieveEntity) o;
        return achieveId == that.achieveId &&
                userId == that.userId &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(favorite, that.favorite) &&
                Objects.equals(clazz, that.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(achieveId, userId, tags, favorite, clazz);
    }
}
