package vine.app.dao.auto;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.UserEnroll;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by liguofang on 2014/10/27.
 */
@AutoDao
public interface EnrollDao {


    public UserEnroll findEnrollByMobileNo(@Param("mobileNo") String mobileNo);
    public UserEnroll findEnrollByEmail(@Param("email") String email) ;

  /***/
    public int insertEnroll(UserEnroll userEnroll);
    public void updateEnroll(UserEnroll userEnroll);

    public List<UserEnroll> selectAllEnroll();

    public void deleteEnrollBySeqno(@Param("seqno") int seqno);

    public void resetPasswordByUserId(@Param("userId") String userId,@Param("password") String password);



}
