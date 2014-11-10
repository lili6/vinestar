package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.UserEnroll;
import vine.app.dao.model.social.SocialTopic;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 社交主题DAO
 */
@AutoDao
public interface SocialTopicDao {

    /**
     * 新增一条主题
     * @param socialTopic
     * @return Long topicId
     */
    public Long insertTopic(SocialTopic  socialTopic);
    /**
     * 更新一个主题
     * @param socialTopic
     */
    public void updateTopic(SocialTopic socialTopic);

    /**
     * 根据id删除一条主题
     * @param id
     */
    public void deleteTopic(@Param("id") Long id);

    /**
     * 根据用户id获取此用户发表的所有主题
     * @param userId
     * @return
     */
    public List<SocialTopic> findTopicByUserId(@Param("userId") String userId);

    /**
     * 根据时间顺序获取当前公共主题
     * 缺省显示20条
     * @return
     */
    public List<SocialTopic> findPublicTopic(@Param("count")int count);

    /**
     * 根据主题Id查询主题信息
     * @param id
     * @return
     */
    public SocialTopic selectTopicById(@Param("id") Long id);

}
