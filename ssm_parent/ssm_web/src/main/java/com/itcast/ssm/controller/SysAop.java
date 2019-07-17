package com.itcast.ssm.controller;


import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.ISysService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class SysAop {

    @Autowired
    private ISysService sysService;

    @Autowired
    private HttpServletRequest request;


    private Date visitTime;
    private Class clazz;
    private Method method;

    @Pointcut("execution(* com.itcast.ssm.controller.*.*(..))")
    public void p1(){

    }

    //前置通知

    /*获取访问的第一次时间，访问的地址，访问的类
    * */
    @Before("p1()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
         visitTime=new Date();
         clazz=jp.getTarget().getClass();//要访问的类
        String methodName = jp.getSignature().getName();//方法名
        Object[] args = jp.getArgs();//方法的参数
        if (args==null||args.length==0){
            method = clazz.getMethod(methodName);
        }else{
            Class[] classArgs=new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i]=args[i].getClass();
            }
            method=clazz.getMethod(methodName,classArgs);
        }
    }

    @After("p1()")
    public void doAfter(JoinPoint jp){
    long time=new Date().getTime()-visitTime.getTime();

        String url="";
    if (clazz!=null&&method!=null&&clazz!=SysAop.class){
        RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        if (classAnnotation!=null){
            String[] classAnnotationValue = classAnnotation.value();
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation!=null){
                String[] methodAnnotationValue = methodAnnotation.value();
                //访问路径
                url=classAnnotationValue[0]+methodAnnotationValue[0];
            }
        }
    }

        //获取当前超过的用户名
        SecurityContext context = SecurityContextHolder.getContext();
        User user =(User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        //获取Ip地址
        String ip = request.getRemoteAddr();

        SysLog sysLog=new SysLog();
        sysLog.setIp(ip);
        sysLog.setExecutionTime(time);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);
        sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
        sysLog.setUrl(url);

        sysService.save(sysLog);
    }

}
