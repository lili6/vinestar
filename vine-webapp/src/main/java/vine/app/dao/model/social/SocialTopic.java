package vine.app.dao.model.social;

import vine.app.dao.model.enums.Enabled;
import vine.app.dao.model.enums.Relationship;
import vine.app.dao.model.enums.TopicStatus;
import vine.app.dao.model.enums.VisibleRange;

import java.util.Date;

/**
 * Created by liguofang on 2014/11/10.
 * 社交话题Model
 * TODO:添加地理信息，添加分类信息，关键字信息
 */
public class SocialTopic {
    private Long id;
//    private Integer topicId;
    private String title;
    private String content;
    /*缩略图*/
    private String thumbnail;
    /*原图*/
    private String image ;
    /*本地原图*/
    private String localImage ;

    private String userId;
    /*可见范围*/
    private VisibleRange visibleRange;
    private Integer praiseCount;
    private Integer commentCount;
    private Integer favoriteCount;
    private Integer fowardCount;

    private TopicStatus status;

    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    @Override
    public String toString() {
        return "SocialTopic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", localImage='" + localImage + '\'' +
                ", userId='" + userId + '\'' +
                ", visibleRange=" + visibleRange +
                ", praiseCount=" + praiseCount +
                ", commentCount=" + commentCount +
                ", favoriteCount=" + favoriteCount +
                ", fowardCount=" + fowardCount +
                ", status=" + status +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocalImage() {
        return localImage;
    }

    public void setLocalImage(String localImage) {
        this.localImage = localImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public VisibleRange getVisibleRange() {
        return visibleRange;
    }

    public void setVisibleRange(VisibleRange visibleRange) {
        this.visibleRange = visibleRange;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Integer getFowardCount() {
        return fowardCount;
    }

    public void setFowardCount(Integer fowardCount) {
        this.fowardCount = fowardCount;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
