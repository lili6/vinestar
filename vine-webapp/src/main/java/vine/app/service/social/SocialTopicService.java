package vine.app.service.social;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vine.app.dao.auto.EnrollDao;
import vine.app.dao.auto.social.SocialTopicDao;
import vine.app.dao.model.social.SocialTopic;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liguofang on 2014/11/10.
 */
@Service
public class SocialTopicService {
    private static final Logger log = LoggerFactory.getLogger(SocialTopicService.class);
    @Resource
    private SocialTopicDao socialTopicDao;

    /**
     * 新增一条记录
     * @param socialTopic
     * @return
     */
    public Long insertTopic(SocialTopic  socialTopic) {
        return socialTopicDao.insertTopic(socialTopic);
    }

    public void updateTopic(SocialTopic socialTopic) {

    }

    public void deleteTopic(Long id) {

    }

    public List<SocialTopic> findTopicByUserId(String userId) {
        return socialTopicDao.findTopicByUserId(userId);
    }

    public List<SocialTopic> findPublicTopic(int count){
        return socialTopicDao.findPublicTopic(count);
    }

    /**
     *
     * @param id
     * @return
     */
    public SocialTopic selectTopicById(Long id){
       return socialTopicDao.selectTopicById(id);

    }
}
