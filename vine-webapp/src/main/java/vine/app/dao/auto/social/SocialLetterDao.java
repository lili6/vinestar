package vine.app.dao.auto.social;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.social.SocialComment;
import vine.app.dao.model.social.SocialLetter;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 * 私信DAO
 */
@AutoDao
public interface SocialLetterDao {
    /**
     * 新增一条评论
     * @param socialLetter
     * @return Long topicId
     */
    public Long insertLetter(SocialLetter socialLetter);
    /**
     * 更新一个评论
     * @param socialLetter
     */
    public void updateLetter(SocialLetter socialLetter);
    /**
     * 根据id删除一条评论
     * @param id
     */
    public void deleteLetter(@Param("id") Long id);
    public List<SocialLetter> findLetterByUserId(@Param("fromUid") String fromUid,@Param("toUid") String toUid);

    /**
     * 根据主题Id查询主题信息
     * @param id
     * @return
     */
    public SocialLetter selectLetterById(@Param("id") Long id);

}
