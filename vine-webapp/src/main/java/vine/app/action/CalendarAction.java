package vine.app.action;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import vine.app.factory.AppBeanFactory;
import vine.app.message.CalendarMessage;
import vine.app.message.HOpCodeEx;
import vine.app.service.CalendarCategoryService;
import vine.app.service.CalendarCommentService;
import vine.app.service.CalendarInfoService;
import vine.common.constant.MessageResult;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.packet.HttpPacket;
import vine.core.net.session.UserSession;

import java.util.List;

/**
 * Created by liguofang on 2014/10/24.
 */
@Controller
@Module(100)
public class CalendarAction {

    private static final Logger log = LoggerFactory.getLogger(CalendarAction.class);
    CalendarInfoService calendarService= AppBeanFactory.getCalendarInfoService();
    CalendarCategoryService calendarCategoryService= AppBeanFactory.getCalendarCategoryService();
    CalendarCommentService calendarCommentService= AppBeanFactory.getCalendarCommentService();

    //==============================日程(列表，详情，增加，修改，删除)=========================
    /**
     * 获取日程列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarList, needOnline = false)
    public HttpPacket findCalendarList (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("findCalendarList begin...");
            log.debug("findCalendarList request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.FindCalendarList req =null;
        try {
            req = CalendarMessage.FindCalendarList.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        String startTime = req.getStartTime();
        String endTime = req.getEndTime();
        String keyword = req.getKeyword();
        Long calCategoryId = req.getCalCategoryId();
        Integer priority=req.getPriority();
        List<CalendarMessage.Calendar> calendarList=calendarService.findCalendarList(session.getUserId(),startTime,endTime,keyword,calCategoryId,priority);
        //step.3AppBody组装
        CalendarMessage.FindCalendarListRet.Builder builder = CalendarMessage.FindCalendarListRet.newBuilder();
        builder.addAllCalendars(calendarList);

        //step.4返回结果组装
        byte[] buff = builder.build().toByteArray();
        packet.packResponse(MessageResult.SUCCESS,buff);
        if(log.isDebugEnabled()){
            log.debug("findCalendarList response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 获取日程列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarById, needOnline = false)
    public HttpPacket findCalendarById (UserSession session, HttpPacket packet) {

        if(log.isDebugEnabled()){
            log.debug("findCalendarById begin...");
            log.debug("findCalendarById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.FindCalendarById req =null;
        try {
            req = CalendarMessage.FindCalendarById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误.
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarId = req.getCalendarId();
        CalendarMessage.Calendar calendar=calendarService.findCalendarById(calendarId);

        //step.3AppBody组装
        CalendarMessage.FindCalendarByIdRet.Builder builder = CalendarMessage.FindCalendarByIdRet.newBuilder();
        builder.setCalendar(calendar);

        //step.4返回结果组装
        byte[] buff = builder.build().toByteArray();
        packet.packResponse(MessageResult.SUCCESS,buff);
        if(log.isDebugEnabled()){
            log.debug("findCalendarById response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 日程增加接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.AddCalendar, needOnline = false)
    public HttpPacket addCalendar (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("addCalendar begin...");
            log.debug("addCalendar request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.AddCalendar req =null;
        try {
            req = CalendarMessage.AddCalendar.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        CalendarMessage.Calendar calendar= req.getCalendar();
        calendarService.addCalendar(calendar);

        //step.3appBody封装(无)

        //step.4返回结果封装
        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("addCalendar response packet:{}",packet);
        }

        return packet;
    }

    /**
     * 日程修改接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.EditCalendarById, needOnline = false)
    public HttpPacket editCalendarById (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("editCalendarById begin...");
            log.debug("editCalendarById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.EditCalendarById req =null;
        try {
            req = CalendarMessage.EditCalendarById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        CalendarMessage.Calendar calendar= req.getCalendar();
        calendarService.editCalendarById(calendar);

        //step.3appBody封装(无)

        //step.4返回结果封装
        
        packet.packResponse(MessageResult.SUCCESS,null);
        
        if(log.isDebugEnabled()){
            log.debug("editCalendarById response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 日程删除接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.DeleteCalendarById, needOnline = false)
    public HttpPacket deleteCalendarById (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("editCalendarById begin...");
            log.debug("editCalendarById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.DeleteCalendarById req =null;
        try {
            req = CalendarMessage.DeleteCalendarById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarId= req.getCalendarId();
        calendarService.deleteCalendarById(calendarId);

        //step.3appBody封装(无)

        //step.4返回结果封装
        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("deleteCalendarById response packet:{}",packet);
        }

        return packet;
    }


    //==============================日程类别(列表，详情，增加，修改，删除)=========================

    /**
     * 获取日程类别列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarCategoryList, needOnline = false)
    public HttpPacket findCalendarCategoryList (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("findCalendarCategoryList begin...");
            log.debug("findCalendarCategoryList request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.FindCalendarCategoryList req =null;
        try {
            req = CalendarMessage.FindCalendarCategoryList.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        String startTime = req.getStartTime();
        String endTime = req.getEndTime();
        String keyword = req.getKeyword();
        List<CalendarMessage.CalendarCategory> calendarCategoryList=calendarCategoryService.findCalendarCategoryList(startTime, endTime, keyword);

        //step.3AppBody组装
        CalendarMessage.FindCalendarCategoryListRet.Builder builder = CalendarMessage.FindCalendarCategoryListRet.newBuilder();
        builder.addAllCalendarCategorys(calendarCategoryList);

        //step.4返回结果组装
        byte[] buff = builder.build().toByteArray();
        packet.packResponse(MessageResult.SUCCESS,buff);
        if(log.isDebugEnabled()){
            log.debug("findCalendarCategoryList response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 获取日程列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarCategoryById, needOnline = false)
    public HttpPacket findCalendarCategoryById (UserSession session, HttpPacket packet) {

        if(log.isDebugEnabled()){
            log.debug("findCalendarCategoryById begin...");
            log.debug("findCalendarCategoryById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.FindCalendarCategoryById req =null;
        try {
            req = CalendarMessage.FindCalendarCategoryById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误.
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarCategoryId = req.getCalendarCategoryId();
        CalendarMessage.CalendarCategory calendarCategory=calendarCategoryService.findCalendarCategoryById(calendarCategoryId);

        //step.3AppBody组装
        CalendarMessage.FindCalendarCategoryByIdRet.Builder builder = CalendarMessage.FindCalendarCategoryByIdRet.newBuilder();
        builder.setCalendarCategory(calendarCategory);

        //step.4返回结果组装
        byte[] buff = builder.build().toByteArray();
        packet.packResponse(MessageResult.SUCCESS,buff);
        
        if(log.isDebugEnabled()){
            log.debug("findCalendarCategoryById response packet:{}",packet);
        }
        return packet;
    }


    /**
     * 日程类别增加接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.AddCalendarCategory, needOnline = false)
    public HttpPacket addCalendarCategory (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("addCalendarCategory begin...");
            log.debug("addCalendarCategory request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.AddCalendarCategory req =null;
        try {
            req = CalendarMessage.AddCalendarCategory.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        CalendarMessage.CalendarCategory calendarCategory= req.getCalendarCategory();
        calendarCategoryService.addCalendarCategory(calendarCategory);

        //step.3appBody封装(无)

        //step.4返回结果封装

        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("addCalendarCategory response packet:{}",packet);
        }

        return packet;
    }

    /**
     * 日程类别修改接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.EditCalendarCategoryById, needOnline = false)
    public HttpPacket editCalendarCategoryById (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("editCalendarCategoryById begin...");
            log.debug("editCalendarCategoryById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.EditCalendarCategoryById req =null;
        try {
            req = CalendarMessage.EditCalendarCategoryById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        CalendarMessage.CalendarCategory calendarCategory= req.getCalendarCategory();
        calendarCategoryService.editCalendarCategoryById(calendarCategory);

        //step.3appBody封装(无)

        //step.4返回结果封装
        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("editCalendarCategoryById response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 日程类别删除接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.DeleteCalendarCategoryById, needOnline = false)
    public HttpPacket deleteCalendarCategoryById (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("deleteCalendarCategoryById begin...");
            log.debug("deleteCalendarCategoryById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.DeleteCalendarCategoryById req =null;
        try {
            req = CalendarMessage.DeleteCalendarCategoryById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarCategoryId= req.getCalendarCategoryId();
        calendarCategoryService.deleteCalendarCategoryById(calendarCategoryId);

        //step.3appBody封装(无)

        //step.4返回结果封装
        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("deleteCalendarCategoryById response packet:{}",packet);
        }

        return packet;
    }

//==============================日程追加(列表，详情，增加，修改，删除)=========================

    /**
     * 获取日程类别列表接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.FindCalendarCommentList, needOnline = false)
    public HttpPacket findCalendarCommentList (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("findCalendarCommentList begin...");
            log.debug("findCalendarCommentList request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.FindCalendarCommentList req =null;
        try {
            req = CalendarMessage.FindCalendarCommentList.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarId = req.getCalendarId();
        List<CalendarMessage.CalendarComment> calendarCommentList=calendarCommentService.findCalendarCommentListByCalId(calendarId);

        //step.3AppBody组装
        CalendarMessage.FindCalendarCommentListRet.Builder builder = CalendarMessage.FindCalendarCommentListRet.newBuilder();
        builder.addAllCalendarComments(calendarCommentList);

        //step.4返回结果组装
        byte[] buff = builder.build().toByteArray();
        packet.packResponse(MessageResult.SUCCESS,buff);
        
        if(log.isDebugEnabled()){
            log.debug("findCalendarCategoryList response packet:{}",packet);
        }

        return packet;
    }




    /**
     * 日程评论增加接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.AddCalendarComment, needOnline = false)
    public HttpPacket addCalendarComment (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("addCalendarComment begin...");
            log.debug("addCalendarComment request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.AddCalendarComment req =null;
        try {
            req = CalendarMessage.AddCalendarComment.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        CalendarMessage.CalendarComment calendarComment= req.getCalendarComment();
        calendarCommentService.addCalendarComment(calendarComment);

        //step.3appBody封装(无)

        //step.4返回结果封装
        
        packet.packResponse(MessageResult.SUCCESS,null);
        
        if(log.isDebugEnabled()){
            log.debug("addCalendarComment response packet:{}",packet);
        }

        return packet;
    }


    /**
     * 日程追加删除接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.DeleteCalendarCommentById, needOnline = false)
    public HttpPacket deleteCalendarCommentById (UserSession session, HttpPacket packet) {
        if(log.isDebugEnabled()){
            log.debug("deleteCalendarCommentById begin...");
            log.debug("deleteCalendarCommentById request userId:{} packet:{}",session.getUserId(),packet);
        }

        //step.1接口数据验证
        CalendarMessage.DeleteCalendarCommentById req =null;
        try {
            req = CalendarMessage.DeleteCalendarCommentById.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }

        //step.2业务逻辑
        Long calendarId= req.getCalendarId();
        Long calendarCommentId= req.getCalendarCommentId();
        calendarCommentService.deleteCalendarCommentById(calendarId,calendarCommentId);

        //step.3appBody封装(无)

        //step.4返回结果封装
        
        packet.packResponse(MessageResult.SUCCESS,null);
        if(log.isDebugEnabled()){
            log.debug("deleteCalendarCommentById response packet:{}",packet);
        }
        return packet;
    }



}
