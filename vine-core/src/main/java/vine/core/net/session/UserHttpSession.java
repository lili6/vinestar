/**
 * 
 */
package vine.core.net.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.core.net.packet.HttpPacket;
import vine.core.net.packet.PacketConst;
import vine.core.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于Http的用户会话实现类
 * @author liguofang
 */
public class UserHttpSession extends UserSession implements Serializable {
	private static final long serialVersionUID = 5233110833583718220L;
	private static final Logger log = LoggerFactory.getLogger(UserHttpSession.class);
	private transient HttpSession httpSession;
	/*每个packetId对应一个stream*/
	private transient Map<Integer, OutputStream> streams = new HashMap<Integer, OutputStream>();

	private String remoteAddr;
    private HttpServletResponse httpResponse;
	UserHttpSession(HttpSession httpSession){
		this.httpSession = httpSession;
		this.sessionId = httpSession.getId();
	}
	
	@Override
	public void responseImmediately(HttpPacket packet) {
		log.info("responseImmediately.....");
		if(packet == null) {
			log.error("返回packet=null,处理忽略!!!");
			return;
		}
		// 不在这里检查是否在线，外面已做检查
		//分情况来考虑响应数据的输出
		/*
        byte[] willSendMsg = null;
		if (packet.getPacketType() == PacketType.PB) {
			willSendMsg = Packet.packHttpResponse(packet, PacketType.PB);
		} else if (packet.getPacketType() == PacketType.JSON) {
			willSendMsg = Packet.packHttpResponse(packet, PacketType.JSON);
		}
		 */
//        byte[] willSendMsg = "I'm back!!".getBytes();
        byte[] willSendMsg = packet.getAppBody();
        packet.setStamp();
        httpResponse.setHeader(PacketConst.HTTP_KEY_PACKETHEAD,packet.getPacketHead().toJson());
        httpResponse.setHeader(PacketConst.HTTP_KEY_APPHEAD, packet.getAppHead().toJson());
//        httpResponse.setHeader(PacketConst.APP_HEAD, "TEST APP HEAD...");

		int command = packet.getPacketId();// 使用请求的命令编号作为获取缓存的OutputStream的ID//		
		if (command > 0) {
			OutputStream stream = streams.get(command);
//			OutputStream stream = streams.get(this.sessionId); //根据sessionId获取缓存的OutputStream
			if(log.isDebugEnabled()) {log.debug("==packetId[{}],stream:{},",command,stream);}
			try {
                if (willSendMsg !=null) { //消息体不为空
                    stream.write(willSendMsg);
				    log.info("PacketId[{}]发送数据完毕! \n ",command);
                }
			} catch (Exception e) {
				log.error("响应数据出错：MessageId[{}]" , command); // TODO 设置响应数据
				e.printStackTrace();
			} finally{
				try {
					if(stream!=null)
						stream.close();
				} catch (Exception e) {	
					log.error("packetId[{}]响应数据关闭输出流异常：{},{}",command,e.getCause(),e.getMessage());
					
				}
				if(log.isDebugEnabled()) {log.debug("移除缓存的OutputStream,SessionId[{}]",this.sessionId);}
				streams.remove(command);
			}			
		}
	}

	/*
	 * HTTP类的push消息全部将其缓存入用户的数据待取对象中，等待客户端自动检查是否有新数据
	 */
	@Override
	public void response(HttpPacket packet) {
		beforeResponse(packet);
		responseImmediately(packet);
	}
	
	@Override
	public void push(HttpPacket packet) {
		if(packet == null) return;
		// 不在这里检查是否在线，外面已做检查
		if (waitMessage == null) return;
		waitMessage.add(packet);
		messageLastAddTime = System.currentTimeMillis();
	}

	@Override
	protected boolean destroy(boolean isPassive) {
		if (connected) {
			connected = false;
			if(!isPassive){//如果是主动销毁
				try {
					if (httpSession != null) httpSession.invalidate();
				} catch (Exception e) {
					if (log.isDebugEnabled()) {
						log.debug("HTTP会话已关闭，不能重复关闭，HttpSessionId：" + sessionId);
					}
				}
			}
			if (closedListeners != null) {
				for (UserSessionClosedListener l : closedListeners) {
					l.onClosed(this);
				}
			}
		}
		return true;
	}
	@Override
	protected boolean create() {
		if (connected) {
			if (createdListeners != null) {
				if (log.isDebugEnabled()) {
					log.debug("HTTP用户会话创建监听器开始执行：" );
				}
				for (UserSessionCreatedListener l : createdListeners) {
					l.onCreated(this);
				}
			}
		}
		return true;
	}

	@Override
	public String getRemoteAddress() {
		return this.remoteAddr;
	}
	
	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.remoteAddr = httpRequest.getRemoteAddr();
		String encoding = httpRequest.getHeader("Accept-Encoding");
		if (encoding != null && encoding.indexOf("compress") > -1) {
			this.compressed = true;
		}else{
			this.compressed = false;
		}
	}
	
		
	/**
	 * 缓存HttpServletResponse对象
	 * @param packetId 使用请求命令标识请求的唯一ID，用于向客户端发送数据时从缓存中查找response
	 * @param httpResponse
	 */
	public void putHttpResponse(int packetId, HttpServletResponse httpResponse) {
		if (httpResponse != null) {
			try {
               this.httpResponse = httpResponse;
				httpResponse.setCharacterEncoding(PacketConst.MESSAGE_DEFAULT_ENCODING);
				httpResponse.setContentType("text/html;charset=" + PacketConst.MESSAGE_DEFAULT_ENCODING);
				httpResponse.setHeader("Pragma","No-cache");
				httpResponse.setDateHeader("Expires",0);
				httpResponse.setHeader("Cache-Control","no-cache");
				OutputStream stream = httpResponse.getOutputStream();
				if (streams == null) streams = new HashMap<Integer, OutputStream>();
				if(log.isDebugEnabled()) {log.debug("设置输出流缓存:packetId[{}]",packetId);}
				streams.put(packetId, stream);
				if(log.isDebugEnabled()) {log.debug("设置输出流缓存Streams:[{}]",streams);}
			} catch (Exception e) {
				log.error("获取用于发送数据的Http PrintWriter出错!",e);
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserHttpSession [httpSession=");
		builder.append(httpSession);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", attributes=");
		builder.append(attributes);
		builder.append(", waitMessage=");
		builder.append(waitMessage);
		builder.append("]");
		return builder.toString();
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

}
