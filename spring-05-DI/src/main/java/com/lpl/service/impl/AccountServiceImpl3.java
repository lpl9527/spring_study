package com.lpl.service.impl;

import com.lpl.service.IAccountService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 账户的业务层实现类    ---演示集合类型的Setter方式注入
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] myArray;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println(Arrays.toString(myArray));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }

}
