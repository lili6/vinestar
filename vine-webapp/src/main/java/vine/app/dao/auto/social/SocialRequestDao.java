package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.social.SocialRequest;
import vine.app.dao.model.social.SocialTopic;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 用户加好友请求DAO
 */
@AutoDao
public interface SocialRequestDao {

    /**
     * 新增一条主题
     * @param socialRequest
     * @return Long id
     */
    public Long insertRequest(SocialRequest socialRequest);
    /**
     * 更新一个通知，比如将状态改为已读，或者同意，拒绝
     * @param socialRequest
     */
    public void updateRequest(SocialRequest socialRequest);

    /**
     * 根据id删除一条通知
     * @param id
     */
    public void deleteRequest(@Param("id") Long id);

    /**
     * 根据用户id获取此用户发表的所有通知
     * @param userId
     * @param  isRead 是否阅读，如果不输入则查询该用户所有的通知
     * @return
     */
    public List<SocialRequest> findRequestByUserId(@Param("userId") String userId, @Param("isRead") Integer isRead);

    /**
     * 根据Id查询请求信息
     * @param id
     * @return
     */
    public SocialTopic selectRequestById(@Param("id") Long id);

}
