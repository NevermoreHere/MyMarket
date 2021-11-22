package com.exa.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/connectWebSocket/{userId}")
public class WebSocket {
    public static int onlineNumber = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String userId;

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session){
        onlineNumber ++;
        clients.put(userId, this);
        System.out.println("现在来连接的客户id" + session.getId() + "用户名" + userId);
        this.userId = userId;
        this.session = session;
    }

    @OnClose
    public void onClose(){
        onlineNumber --;
        clients.remove(this.userId);
        try {
            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 2);
            map1.put("onlineUsers", clients.keySet());
            map1.put("userId", userId);
            sendMessageAll(JSON.toJSONString(map1), userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("当前连接人数" + onlineNumber);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        try{
            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String fromUserId = jsonObject.getString("userId");
            String toUserId = jsonObject.getString("to");

            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 4);
            map1.put("textMessage", textMessage);
            map1.put("fromUserId", fromUserId);
            if (toUserId.equals("All")) {
                map1.put("toUserId", "所有人");
                sendMessageAll(JSON.toJSONString(map1), fromUserId);
            } else {
                map1.put("toUserId", toUserId);
                System.out.println("开始推送消息给" + toUserId);
                sendMessageTo(JSON.toJSONString(map1), toUserId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageTo(String message, String toUserId) throws IOException {
        for (WebSocket item : clients.values()) {
            System.out.println("给指定的在线用户发送消息,在线人员名单：【" + item.userId + "】发送消息:" + message);
            if (item.userId.equals(toUserId)) {
                item.session.getAsyncRemote().sendText(message);
                break;
            }
        }
    }

    public void sendMessageAll(String message, String fromUserId) throws IOException {
        for (WebSocket item : clients.values()) {
            log.info("给所有在线用户发送给消息，在线人员名单：【" + item.userId + "】发送消息:" + message);
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }
}
