package com.zhang.example01aop.asp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.zhang.example01aop.controller..*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        logger.info("==============================start==============================");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //url
        logger.info("url=" + request.getRequestURL());

        //methon
        logger.info("method=" + request.getMethod());

        //ip
        logger.info("ip=" + request.getRemoteHost());

        //类方法
        logger.info("class_method=" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //get的参数
        if(request.getMethod().equalsIgnoreCase("GET")){
            Object[] args = joinPoint.getArgs();
            Object[] arguments  = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                    continue;
                }
                arguments[i] = args[i];
            }
            if (arguments != null) {
                try {
                    logger.info( JSONObject.toJSONString(arguments));
                } catch (Exception e) {
                    logger.info(arguments.toString());
                }
            }
            //其他方法的参数
        }else {
            //参数
            Object[] objs = joinPoint.getArgs();
            List args = new ArrayList();
            for (Object obj : objs) {
                if ((obj instanceof HttpServletRequest) || (obj instanceof HttpServletResponse) || obj instanceof BindingResult) {
                    continue;
                }
                args.add(obj);
            }
            if (!CollectionUtils.isEmpty(args)) {
                logger.info("args=" + JSON.toJSONString(args));
            }
        }

    }


    @AfterReturning(returning = "object", pointcut = "log()")
    public void adAfterReturning(Object object) {
        logger.info("resopnse=" + JSON.toJSONString(object));
        logger.info("==============================end==============================");
    }

}
