package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class LogDemoContoroller {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody // 문자로 그대로 응답가능
    public String logDemo(HttpServletRequest request) {
        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString(); //고객이 어떤 URL로 요청했는지 알 수 있음
        myLogger.setRequestURL(requestURL);

        myLogger.log("conroller test");
        logDemoService.logic("testId");
        return "ok";
    }

    @RequestMapping("log-demo")
    @ResponseBody // 문자로 그대로 응답가능
    public String logDemo(HttpServletRequest request) {
        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString(); //고객이 어떤 URL로 요청했는지 알 수 있음
        myLogger.setRequestURL(requestURL);

        myLogger.log("conroller test");
        logDemoService.logic("testId");
        return "ok";
    }



}
