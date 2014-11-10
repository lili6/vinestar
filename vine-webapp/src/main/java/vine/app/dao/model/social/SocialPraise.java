package vine.app.dao.model.social;

import vine.app.dao.model.enums.Enabled;
import vine.app.dao.model.enums.IsRead;
import vine.app.dao.model.enums.Relationship;

import java.util.Date;

/**
 * Created by liguofang on 2014/11/10.
 * 点赞信息
 */
public class SocialPraise {
    private Long id;
//    private Integer praiseId;
    private Integer topicId;
    /*被赞用户Id*/
    private String userId;
    /*点赞用户Id*/
    private String praiseUserId;
    private IsRead isRead;

    private Relationship realtionship;

    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    @Override
    public String toString() {
        return "SocialPraise{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", userId='" + userId + '\'' +
                ", praiseUserId='" + praiseUserId + '\'' +
                ", isRead=" + isRead +
                ", realtionship=" + realtionship +
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPraiseUserId() {
        return praiseUserId;
    }

    public void setPraiseUserId(String praiseUserId) {
        this.praiseUserId = praiseUserId;
    }

    public IsRead getIsRead() {
        return isRead;
    }

    public void setIsRead(IsRead isRead) {
        this.isRead = isRead;
    }

    public Relationship getRealtionship() {
        return realtionship;
    }

    public void setRealtionship(Relationship realtionship) {
        this.realtionship = realtionship;
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
