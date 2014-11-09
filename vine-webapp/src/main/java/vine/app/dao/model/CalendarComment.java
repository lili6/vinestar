package vine.app.dao.model;

import vine.app.dao.model.enums.Enabled;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by renfj on 2014/11/03.
 * 日程追加信息表
 */
public class CalendarComment {
    private Long seqno;
    private String userId;
    private Long calendarId;

    private String calCommentDesc;
    private String calCommentPic;
    private String calCommentVoice;
    private String calCommentVideo;

    private BigDecimal longitude;
    private BigDecimal latitude;
    private String localInfo;

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

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalCommentDesc() {
        return calCommentDesc;
    }

    public void setCalCommentDesc(String calCommentDesc) {
        this.calCommentDesc = calCommentDesc;
    }

    public String getCalCommentPic() {
        return calCommentPic;
    }

    public void setCalCommentPic(String calCommentPic) {
        this.calCommentPic = calCommentPic;
    }

    public String getCalCommentVoice() {
        return calCommentVoice;
    }

    public void setCalCommentVoice(String calCommentVoice) {
        this.calCommentVoice = calCommentVoice;
    }

    public String getCalCommentVideo() {
        return calCommentVideo;
    }

    public void setCalCommentVideo(String calCommentVideo) {
        this.calCommentVideo = calCommentVideo;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getLocalInfo() {
        return localInfo;
    }

    public void setLocalInfo(String localInfo) {
        this.localInfo = localInfo;
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
        return "CalendarCommentInfo{" +
                "seqno=" + seqno +
                ", userId=" + userId +
                ", calendarId=" + calendarId +

                ", calCommentDesc='" + calCommentDesc + '\'' +
                ", calCommentPic='" + calCommentPic + '\'' +
                ", calCommentVoice=" + calCommentVoice +
                ", calCommentVideo=" + calCommentVideo +

                ", longitude=" + longitude +
                ", latitude='" + latitude + '\'' +
                ", localInfo='" + localInfo + '\'' +

                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
