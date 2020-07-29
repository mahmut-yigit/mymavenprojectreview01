package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.transform.sax.SAXSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver driver;
    //Create a class name : DropDown
    //Go to https://the-internet.herokuapp.com/dropdown
    //1.Select and Print Option 1 using index
    //2.Select and Print Option 2 by value
    //3.Select and Print default value by visible text
    //4.Print all dropdown values
    //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @Test
    public void dropdownTest(){
        WebElement selectElement=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options =new Select(selectElement);
        String firstSelectedOption=options.getFirstSelectedOption().getText();
        System.out.println("First select options: "+firstSelectedOption);
        options.selectByIndex(1);
        options.selectByValue("2");
        options.selectByVisibleText("Option 1");
        List<WebElement> allOptions= options.getOptions();
        for (WebElement option:allOptions){
            System.out.println(option.getText());
        }
        System.out.println(options.getOptions().size()== 4 ? true : false);

        int size=options.getOptions().size();
        if (size==3){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        Assert.assertTrue(size==4);
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
