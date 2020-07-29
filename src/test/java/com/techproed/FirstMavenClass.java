package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.name("q"));
        Faker faker=new Faker();
        searchBox.sendKeys(faker.name().fullName()+ Keys.ENTER);

        System.out.println(faker.name().title());



    }


}
