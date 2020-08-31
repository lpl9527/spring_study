package com.lpl.cglib;

import com.lpl.proxy.IProducer;

/**
 * 生产者（生产厂家的代理商）
 */
public class Producer{

    /**
     * 销售产品
     */
    public void saleProduct(Float money){
        System.out.println("生产者销售了产品，拿到钱： " + money);
    }
    /**
     * 提供售后服务
     */
    public void afterService(Float money){
        System.out.println("生产者提供了售后服务，收取了服务费： " + money);
    }
}
