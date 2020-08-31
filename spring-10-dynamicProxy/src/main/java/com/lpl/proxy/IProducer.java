package com.lpl.proxy;

/**
 * 生产者厂家提供的接口（即标准），需要生产者（即代理商）继承（即遵守）
 */
public interface IProducer {

    /**
     * 销售产品
     */
    public void saleProduct(Float money);
    /**
     * 提供售后服务
     */
    public void afterService(Float money);
}
