package com.zxa.shortcut.controller;

/**
 * @ClassName: WebSocketServe
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/12/17 14:58
 */

import com.zxa.shortcut.bean.ExcelData;
import com.zxa.shortcut.utils.ExportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@Slf4j
//@ServerEndpoint("/websocket/{user}")
@ServerEndpoint(value = "/api/websocket")
@Component
public class WebSocketServer {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);     //加入set中
		addOnlineCount();           //在线数加1
		log.info("有新连接加入！当前在线人数为" + getOnlineCount());
		try {
			sendMessage("连接成功");
		} catch (IOException e) {
			log.error("websocket IO异常");
		}
	}
	//	//连接打开时执行
	//	@OnOpen
	//	public void onOpen(@PathParam("user") String user, Session session) {
	//		currentUser = user;
	//		System.out.println("Connected ... " + session.getId());
	//	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("来自客户端的消息:" + message);

		//群发消息
		for (WebSocketServer item : webSocketSet) {
			try {
				ByteArrayOutputStream outputSream = new ByteArrayOutputStream();
				download(outputSream);
				item.session.getBasicRemote().sendBinary(ByteBuffer.wrap(outputSream.toByteArray()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		log.error("发生错误");
		error.printStackTrace();
	}


	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	public void sendMessage2() throws IOException {
		OutputStream stream = this.session.getBasicRemote().getSendStream();
		download(stream);
	}

	public void sendMessage1(ByteArrayOutputStream outputStream) throws IOException {
		this.session.getBasicRemote().sendBinary(ByteBuffer.wrap(outputStream.toByteArray()));
	}

	/**
	 * 群发自定义消息
	 */
	public static void sendInfo(String message) throws IOException {
		log.info(message);
		for (WebSocketServer item : webSocketSet) {
			try {

				item.sendMessage(message);
			} catch (IOException e) {
				continue;
			}
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}

	static List<List<Object>> lists = new ArrayList<>(10000);

	static {
		for (int i = 0; i < 1000; i++) {
			List<Object> objects = new ArrayList<>(2);
			objects.add("name" + i);
			objects.add("operationagsddgadgdfhhhhhhhhhshhsdhdfs" + i);
			objects.add("operation" + i);
			objects.add("operation" + i);
			objects.add("operation" + i);
			lists.add(objects);
		}
	}

	public synchronized void download(OutputStream outputStream) {

		long start = System.currentTimeMillis();
		log.info("Enter download" + start);

		ExcelData excelData = new ExcelData();
		excelData.setName("test");
		excelData.setRows(lists);
		List<String> titles = new ArrayList() {{
			add("name");
			add("operation");
			add("operation");
			add("operation");
			add("operation");
		}};
		excelData.setTitles(titles);
			log.info("export xml" + System.currentTimeMillis());
			SXSSFWorkbook wb = new SXSSFWorkbook();
			try {
				String sheetName = excelData.getName();
				if (null == sheetName) {
					sheetName = "Sheet1";
				}
				SXSSFSheet sheet = wb.createSheet(sheetName);
				sheet.protectSheet("test");
				ExportExcelUtils.writeExcel(wb, sheet, excelData);


				wb.write(outputStream);
			} catch (Exception e) {
				try {
					wb.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

			long end = System.currentTimeMillis();
			log.info("Exit download" + (end - start));
	}

}

