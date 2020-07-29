package com.techproed;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotation {
    @Test
    public void Test1(){
        System.out.println("Printing Test1");
    }
    @Before
    //@Test
    public void Test2(){
        System.out.println("Printing Test2");
    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("Printing Test3");
        System.out.println("GitHub icin deneme");
        
    }

}
