package vine.app.dao.model.social;

import vine.app.dao.model.enums.*;

import java.util.Date;

/**
 * Created by liguofang on 2014/11/10.
 * 用户通知Model
 */
public class SocialNotice {
    private Long id   ;
//    private Integer noticeId;
    private NoticeType noticeType;
    private String userId;
    private Integer topicId;
    private Integer commentId;
    private Integer praiseId;
    private IsRead isRead;

    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    @Override
    public String toString() {
        return "SocialNotice{" +
                "id=" + id +
                ", noticeType=" + noticeType +
                ", userId='" + userId + '\'' +
                ", topicId=" + topicId +
                ", commentId=" + commentId +
                ", praiseId=" + praiseId +
                ", isRead=" + isRead +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public IsRead getIsRead() {
        return isRead;
    }

    public void setIsRead(IsRead isRead) {
        this.isRead = isRead;
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
}
