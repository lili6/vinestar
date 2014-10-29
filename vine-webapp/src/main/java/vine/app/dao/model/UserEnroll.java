package vine.app.dao.model;

import vine.app.dao.model.enums.Enabled;
import vine.app.dao.model.enums.EnrollStatus;

import java.sql.Date;

/**
 * Created by liguofang on 2014/10/27.
 * 用户注册信息表
 */
public class UserEnroll {
    private long seqno;
    private String userId;
    private String mobileNo;
    private String email;
    private String password;
    private EnrollStatus status;
    private Date createTime;
    private String creator ;
    private Date updateTime;
    private String updater;
    private Enabled enabled;

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnrollStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollStatus status) {
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

    @Override
    public String toString() {
        return "UserEnroll{" +
                "seqno=" + seqno +
                ", userId=" + userId +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
