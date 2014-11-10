package vine.app.dao.model.social;

import vine.app.dao.model.enums.Enabled;
import vine.app.dao.model.enums.IsAgree;
import vine.app.dao.model.enums.IsRead;
import vine.app.dao.model.enums.Relationship;

import java.util.Date;

/**
 * Created by liguofang on 2014/11/10.
 * 好友请求信息
 */
public class SocialRequest {
    private Long id;
//    private Integer requestId;
    /*被赞用户Id*/
    private String userId;
    /*点赞用户Id*/
    private String requestUserId;
    private IsRead isRead;
    private IsAgree isAgree;
    /*请求信息*/
    private String content;


    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    @Override
    public String toString() {
        return "SocialRequest{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", requestUserId='" + requestUserId + '\'' +
                ", isRead=" + isRead +
                ", isAgree=" + isAgree +
                ", content='" + content + '\'' +
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(String requestUserId) {
        this.requestUserId = requestUserId;
    }

    public IsRead getIsRead() {
        return isRead;
    }

    public void setIsRead(IsRead isRead) {
        this.isRead = isRead;
    }

    public IsAgree getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(IsAgree isAgree) {
        this.isAgree = isAgree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
