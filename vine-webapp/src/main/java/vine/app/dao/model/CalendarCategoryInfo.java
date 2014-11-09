package vine.app.dao.model;

import vine.app.dao.model.enums.Enabled;

import java.sql.Date;

/**
 * Created by renfj on 2014/11/03.
 * 日程信息表
 */
public class CalendarCategoryInfo {
    private Long seqno;
    private String userId;
    private String name;
    private Integer showOrder;

    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
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

    @Override
    public String toString() {
        return "CalendarCategoryInfo{" +
                "seqno=" + seqno +
                ", userId=" + userId +
                ", name=" + name +
                ", showOrder='" + showOrder + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
