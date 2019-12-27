package com.jiangcl.springmvc.websocket;

import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiangcl
 * @date 2019/12/26
 * @desc 通过webSocket向前端推送消息
 */
@ServerEndpoint("/webSocket/{username}")
public class WebSocket {

    private static int onlineCount = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String username;

    /**
     * @desc 建立连接
     * @author jiangcl
     * @date 2019/12/27
     * @param username
     * @param session
     * @return void
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {

        this.username = username;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
        System.out.println(username + " 已连接");
    }

    /**
     * @desc 关闭连接
     * @author jiangcl
     * @date 2019/12/27
     * @param
     * @return void
     */
    @OnClose
    public void onClose() throws IOException {
        clients.remove(username);
        subOnlineCount();
        System.out.println(username + " 已断开");
    }

    /**
     * @desc 消息接收
     * @author jiangcl
     * @date 2019/12/27
     * @param message
     * @return void
     */
    @OnMessage
    public void onMessage(String message) throws IOException {

        /*JSONObject jsonTo = JSONObject.fromObject(message);
        String mes = (String) jsonTo.get("message");

        if (!jsonTo.get("To").equals("All")){
            sendMessageTo(mes, jsonTo.get("To").toString());
        }else{
            sendMessageAll("给所有人");
        }*/
    }

    /**
     * @desc 异常处理
     * @author jiangcl
     * @date 2019/12/27
     * @param session
     * @param error
     * @return void
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 发送消息给指定用户
     * @param message
     * @param to
     * @throws IOException
     */
    public void sendMessageTo(String message, String to) throws IOException {
        /*for (WebSocket item : clients.values()) {
            if (item.username.equals(To) )
                item.session.getAsyncRemote().sendText(message);
        }*/
        if(!StringUtils.isEmpty(to)){
            System.out.println("将消息 '" + message + "' 发送用户 '" + to + "'");
            WebSocket webSocket = clients.get(to);
            if(webSocket != null){
                webSocket.session.getAsyncRemote().sendText(message);
            }
        }

    }

    /**
     * @desc 给所有在线用户发送消息
     * @author jiangcl
     * @date 2019/12/27
     * @param message
     * @return void
     */
    public void sendMessageAll(String message) throws IOException {
        System.out.println("将消息 '" + message + "' 发送给全部用户");
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }
}
