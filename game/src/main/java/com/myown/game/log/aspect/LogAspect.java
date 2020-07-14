package com.myown.game.log.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class LogAspect {

    @Pointcut(value = "execution(public * com.myown.game.controller.*.*(..))")
    //@Pointcut(value = "@annotation(com.myown.game.constant.TestAnnotation)")
    public void logPointCut(){
    }

    @Around(value = "logPointCut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("------------------start---------------");
        try{
            joinPoint.proceed();
        }catch(Throwable ex){
            ex.printStackTrace();
        }
    }

    @Before(value = "logPointCut()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("-     时间 : " + df.format(new Date()));
        System.out.println("-     URL : " + request.getRequestURL().toString());
        System.out.println("-     访问方式 : " + request.getMethod());
        System.out.println("-     访问IP : " + getIpAdrress(request));
        System.out.println("-     访问方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("-     参数 : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "logPointCut()",returning = "response")
    public void afterReturn(Object response){
        System.out.println("返回值:"+response);
        System.out.println("------------------end---------------");
    }

    private static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}
