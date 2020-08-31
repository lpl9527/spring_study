package com.lpl.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类
 */
public class Logger {

    /**
     * 前置通知方法
     *
     * 用于打印日志，计划让其在切入点方法执行（业务层方法）之前执行
     */
    public void beforePrintLog(){
        System.out.println("Logger类中的前置通知方法开始记录日志了...");
    }
    /**
     * 后置通知
     */
    public void afterPrintLog(){
        System.out.println("Logger类中的后置通知方法开始记录日志了...");
    }
    /**
     * 异常通知
     */
    public void exceptionPrintLog(){
        System.out.println("Logger类中的异常通知方法开始记录日志了...");
    }
    /**
     * 最终通知
     */
    public void finalPrintLog(){
        System.out.println("Logger类中的最终通知方法开始记录日志了...");
    }
    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }

}
