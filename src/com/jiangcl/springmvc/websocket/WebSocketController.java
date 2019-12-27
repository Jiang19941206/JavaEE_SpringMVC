package com.jiangcl.springmvc.websocket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jiangcl
 * @date 2019/12/26
 * @desc
 */
@Controller
public class WebSocketController {
    private static String userName;

    @RequestMapping("/websocket")
    public String webSocketPage( String userName, Model model){
        this.userName = userName;
        model.addAttribute("userName",userName);
        return "websocket";
    }

    @Scheduled(cron = "0/10 * * * * ? ")
    public void sendMessage() throws IOException {
        WebSocket webSocket = new WebSocket();
        String message = "现在是北京时间：";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = formatter.format(localDateTime);
        message = message + dateStr;
        //webSocket.sendMessageTo(message,userName);
        webSocket.sendMessageAll(message);
    }
}
