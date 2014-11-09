package vine.app.dao.model;

import vine.app.dao.model.enums.Enabled;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 * 日程信息表
 */
public class CalendarInfo {
    private Long seqno;
    private String userId;
    private Long calCategoryId;

    private String calName;
    private String calDesc;
    private String calPic;
    private String calVoice;
    private String calVideo;

    private Integer priority;
    private Integer alterEnabled;
    private Integer openEnabled;
    private Integer endEnabled;

    private Long alterTime;
    private Integer alterForward;

    private BigDecimal longitude;
    private BigDecimal latitude;
    private String localInfo;

    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    private List<CalendarComment> calendarComments=new ArrayList<CalendarComment>();

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

    public Long getCalCategoryId() {
        return calCategoryId;
    }

    public void setCalCategoryId(Long calCategoryId) {
        this.calCategoryId = calCategoryId;
    }

    public String getCalName() {
        return calName;
    }

    public void setCalName(String calName) {
        this.calName = calName;
    }

    public String getCalDesc() {
        return calDesc;
    }

    public void setCalDesc(String calDesc) {
        this.calDesc = calDesc;
    }

    public String getCalPic() {
        return calPic;
    }

    public void setCalPic(String calPic) {
        this.calPic = calPic;
    }

    public String getCalVoice() {
        return calVoice;
    }

    public void setCalVoice(String calVoice) {
        this.calVoice = calVoice;
    }

    public String getCalVideo() {
        return calVideo;
    }

    public void setCalVideo(String calVideo) {
        this.calVideo = calVideo;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAlterEnabled() {
        return alterEnabled;
    }

    public void setAlterEnabled(Integer alterEnabled) {
        this.alterEnabled = alterEnabled;
    }

    public Integer getOpenEnabled() {
        return openEnabled;
    }

    public void setOpenEnabled(Integer openEnabled) {
        this.openEnabled = openEnabled;
    }

    public Integer getEndEnabled() {
        return endEnabled;
    }

    public void setEndEnabled(Integer endEnabled) {
        this.endEnabled = endEnabled;
    }

    public Long getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Long alterTime) {
        this.alterTime = alterTime;
    }

    public Integer getAlterForward() {
        return alterForward;
    }

    public void setAlterForward(Integer alterForward) {
        this.alterForward = alterForward;
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

    public List<CalendarComment> getCalendarComments() {
        return calendarComments;
    }

    public void setCalendarComments(List<CalendarComment> calendarComments) {
        this.calendarComments = calendarComments;
    }

    @Override
    public String toString() {
        return "CalendarInfo{" +
                "seqno=" + seqno +
                ", userId=" + userId +
                ", calCategoryId=" + calCategoryId +

                ", calName='" + calName + '\'' +
                ", calDesc='" + calDesc + '\'' +
                ", calPic='" + calPic + '\'' +
                ", calVoice=" + calVoice +
                ", calVideo=" + calVideo +

                ", priority='" + priority + '\'' +
                ", alterEnabled='" + alterEnabled + '\'' +
                ", openEnabled='" + openEnabled + '\'' +
                ", endEnabled=" + endEnabled +

                ", alterTime=" + alterTime +
                ", alterForward='" + alterForward + '\'' +

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
