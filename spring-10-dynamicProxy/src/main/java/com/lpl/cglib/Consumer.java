package com.lpl.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
         *          2.基于子类的动态代理
         *              涉及的类： Enhancer
         *              提供者：第三方cglib库
         *              如何创建代理对象：
         *                  使用Enhancer类中的create()方法，方法参数：
         *                      Class：固定写法，被代理对象的字节码，和代理对象使用同一个，用于加载代理对象的字节码。
         *                      Callback：用于提供代理增强的类，一般使用Callback的子接口MethodInterceptor，该类一般是匿名内部类。
         *              创建代理对象的要求：
         *                  被代理类不能是最终类。
         */
        com.lpl.cglib.Producer cglibProducer = (com.lpl.cglib.Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *  执行被代理对象的任何方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method    当前执行的方法对象
             * @param args      当前执行的方法中的参数
             * @param methodProxy   当前执行方法的代理对象
             *
             * @return      和被代理对象的方法有相同的返回值
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProducer.saleProduct(10000f);
    }
}
