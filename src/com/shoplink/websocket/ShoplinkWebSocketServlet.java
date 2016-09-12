package com.shoplink.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

public class ShoplinkWebSocketServlet extends WebSocketServlet {

	private static final long serialVersionUID = 1L;
	private static final String GUEST_PREFIX = "Guest";
	private final String FORMAT = "%s : %s";
	
	private final AtomicInteger connectionIds = new AtomicInteger(0);	
	//存储所有可用websocket连接
	private final Set<ShoplinkMessageInbound> connections = new CopyOnWriteArraySet<ShoplinkMessageInbound>();
		
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		String deviceUid = request.getParameter("deviceUid");
		return new ShoplinkMessageInbound(connectionIds.incrementAndGet(), deviceUid);
	}
	
	private final class ShoplinkMessageInbound extends StreamInbound{
		
		private String WS_NAME;
		private String clientName;
		
		private ShoplinkMessageInbound(int id, String deviceUid){
			this.WS_NAME = GUEST_PREFIX + id;
			this.clientName = deviceUid;
		}
		
		/**
		 * 关闭连接
		 */
		@Override
		protected void onClose(int status) {
			connections.remove(this);			
//			System.out.println(String.format(FORMAT, WS_NAME, "closing ......"));
		}
		
		/**
		 * 建立连接
		 */
		@Override
		protected void onOpen(WsOutbound outbound) {
			connections.add(this);
		}
		
		@Override
		protected void onBinaryData(InputStream arg0) throws IOException {
			// TODO Auto-generated method stub
		}

		@Override
		protected void onTextData(Reader reader) throws IOException {
			// TODO Auto-generated method stub
			char[] chArr = new char[1024];
			int len = reader.read(chArr);
			
			//获取客户端发送的消息
			String clientMessage = String.copyValueOf(chArr, 0, len);
//			System.out.println("---shoplink---" + clientMessage);
			broadcast(clientMessage);
			
			//应该同时进行消息的存储（已有Message对象），以便当一方不在线时可以在其上线后提醒
			//可以判断一下目标工位是否在线
		}
		
		/**
		 * WsOutbound用于向客户端浏览器发送消息
		 * @param message
		 * @throws IOException
		 */
		private void broadcast(String message){
			
			String[] strarray = message.split("\\+");
			message = strarray[0];
			String deviceUid = strarray[1];
			
			for(ShoplinkMessageInbound connection : connections){
				try {
					if(connection.clientName.equals(deviceUid)){
						CharBuffer buffer = CharBuffer.wrap(message);
						connection.getWsOutbound().writeTextMessage(buffer);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		
	}

}
