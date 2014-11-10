package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.social.SocialPraise;
import vine.app.dao.model.social.SocialTopic;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 用户点赞DAO
 */
@AutoDao
public interface SocialPraiseDao {

    /**
     * 新增一条主题
     * @param socialPraise
     * @return Long id
     */
    public Long insertPraise(SocialPraise socialPraise);
    /**
     * 更新一个通知，比如将状态改为已读
     * @param socialPraise
     */
    public void updatePraise(SocialPraise socialPraise);

    /**
     * 根据id删除一条通知
     * @param id
     */
    public void deletePraise(@Param("id") Long id);

    /**
     * 根据用户id获取此用户发表的所有通知
     * @param userId
     * @param  isRead 是否阅读，如果不输入则查询该用户所有的通知
     * @return
     */
    public List<SocialPraise> findPraiseByUserId(@Param("userId") String userId, @Param("isRead") Integer isRead);

    /**
     * 根据主题ID查询点赞情况
     * @param topicId
     * @return
     */
    public List<SocialPraise> findPraiseByTopicId(@Param("topicId") Long topicId);

    /**
     * 根据主题Id查询通知
     * @param id
     * @return
     */
    public SocialTopic selectPraiseById(@Param("id") Long id);

}
