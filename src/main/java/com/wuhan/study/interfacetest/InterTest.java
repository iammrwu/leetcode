package com.wuhan.study.interfacetest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuhan
 * @date 2021/7/28 18:07
 */
public class InterTest {
    @Autowired
    InterfaceA blackInterfaceA;

    static InterfaceA a;
    public static void main(String[] args) {
        String msg="1234";
        a.aaa(msg);
    }

    public InterTest(InterfaceA a2) {
        a=a2;
    }

    public void  setA(InterfaceA a1){
        a=a1;
    }
}
