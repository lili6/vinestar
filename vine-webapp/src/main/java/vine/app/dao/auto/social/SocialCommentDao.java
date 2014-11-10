package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.social.SocialComment;
import vine.app.dao.model.social.SocialTopic;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 社交主题评论DAO
 */
@AutoDao
public interface SocialCommentDao {
    /**
     * 新增一条评论
     * @param socialComment
     * @return Long topicId
     */
    public Long insertComment(SocialComment socialComment);
    /**
     * 更新一个评论
     * @param socialComment
     */
    public void updateComment(SocialComment socialComment);
    /**
     * 根据id删除一条评论
     * @param id
     */
    public void deleteTopic(@Param("id") Long id);
    public List<SocialComment> findCommentByTopicId(@Param("topicId") String topicId);
    public List<SocialComment> findCommentByUserId(@Param("userId") String userId);
    /**
     * 根据主题Id查询主题信息
     * @param id
     * @return
     */
    public SocialComment selectCommentById(@Param("id") Long id);

}
