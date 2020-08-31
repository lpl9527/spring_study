package com.lpl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 消费者
 */
public class Consumer {

    public static void main(String[] args) {
        //实例化一个生产者
        final Producer producer = new Producer();

        /**
         * 动态代理：
         *      作用：不修改源码的基础上对方法进行增强
         *      分类：
         *          1.基于接口的动态代理
         *              涉及的类： Proxy
         *              提供者：JDK
         *              如何创建代理对象：
         *                  使用Proxy类中的newProxyInstance()方法，方法参数：
         *                      ClassLoader：固定写法，被代理对象的类加载器，和代理对象使用同一个，用于加载代理对象的字节码。
         *                      Class[]：固定写法，代理对象的字节码数组，用于让代理对象和被代理对象有相同的方法。
         *                      InvocationHandler：用于提供代理增强的代码，一般都是写一个被代理对象的接口的实现类，该类一般是匿名内部类。
         *              创建代理对象的要求：
         *                  被代理类最少实现一个接口，否则不能使用。
         */
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的接口中的任何方法都会经过此方法
                     * @param proxy 代理对象的引用
                     * @param method    当前执行的方法对象
                     * @param args  当前执行的方法中的参数
                     *
                     * @return      和被代理对象的方法有相同的返回值
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //代理方法的返回结果
                        Object result = null;

                        //-------------提供增强的代码---------------
                        //1.获取方法执行的参数值
                        Float money = (Float)args[0];
                        //2.判断当前方法是不是销售方法
                        if("saleProduct".equals(method.getName())){
                            //将销售的产品的钱抽取出20%，实现动态代理对方法增强
                            money = 0.8f*money;
                            args[0] = money;
                            //调用被代理对象的方法
                            // 注意：匿名内部类访问外部成员变量时，要求外部成员变量是final修饰的
                            result = method.invoke(producer, args);
                        }
                        //-----------------------------------------

                        //返回结果
                        return result;
                    }
                });
        //消费者购买商品，即生产者卖出商品
        proxyProducer.saleProduct(10000f);
    }
}
