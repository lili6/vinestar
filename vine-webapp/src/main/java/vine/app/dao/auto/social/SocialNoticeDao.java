package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.social.SocialNotice;
import vine.app.dao.model.social.SocialTopic;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 用户消息通知DAO
 */
@AutoDao
public interface SocialNoticeDao {

    /**
     * 新增一条主题
     * @param socialNotice
     * @return Long id
     */
    public Long insertNotice(SocialNotice socialNotice);
    /**
     * 更新一个通知，比如将状态改为已读
     * @param socialNotice
     */
    public void updateNotice(SocialNotice socialNotice);

    /**
     * 根据id删除一条通知
     * @param id
     */
    public void deleteNotice(@Param("id") Long id);

    /**
     * 根据用户id获取此用户发表的所有通知
     * @param userId
     * @param  isRead 是否阅读，如果不输入则查询该用户所有的通知
     * @return
     */
    public List<SocialNotice> findNoticeByUserId(@Param("userId") String userId,@Param("isRead") Integer isRead);
    public List<SocialNotice> findNoticeByNoticeType(@Param("userId") String userId,@Param("noticeType") Integer noticeType);

    /**
     * 根据主题Id查询通知
     * @param id
     * @return
     */
    public SocialTopic selectNoticeById(@Param("id") Long id);

}
