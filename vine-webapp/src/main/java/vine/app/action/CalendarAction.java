package vine.app.action;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import vine.app.factory.AppBeanFactory;
import vine.app.message.CalendarMessage;
import vine.app.message.HOpCodeEx;
import vine.app.service.CalendarService;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.packet.HttpPacket;
import vine.core.net.packet.enums.RETCODE;
import vine.core.net.session.UserSession;

import java.util.List;

/**
 * Created by liguofang on 2014/10/24.
 */
@Controller
@Module(100)
public class CalendarAction {
    private static final Logger log = LoggerFactory.getLogger(CalendarAction.class);
    CalendarService calendarService=AppBeanFactory.getCalendarService();
    /**
     * 获取日程列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarList, needOnline = false)
    public HttpPacket findCalendarList (UserSession session, HttpPacket packet) {
        log.debug("findCalendarList begin...");
        log.debug("findCalendarList request packet:{}",packet);
        //接口数据验证
        CalendarMessage.FindCalendarList req =null;
        try {
            req = CalendarMessage.FindCalendarList.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误。。TODO
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.setRetCode(RETCODE.MESSAGE_PARSE_ERROR);
            packet.setAppBody(null);
            return packet;
        }
        String startTime = req.getStartTime();
        String endTime = req.getEndTime();
        String keyword = req.getKeyword();
        Long calCategoryId = req.getCalCategoryId();
        Integer priority=req.getPriority();

        List<CalendarMessage.Calendar> calendarList=calendarService.findCalendarList(startTime,endTime,keyword,calCategoryId,priority);
        CalendarMessage.FindCalendarListRet.Builder builder = CalendarMessage.FindCalendarListRet.newBuilder();
       //TODO
        return packet;
    }

}
