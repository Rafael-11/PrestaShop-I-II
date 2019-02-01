package com.prestashop.utilties;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public  abstract class TestBase {
   protected   WebDriver driver;
   protected Faker faker=new Faker();
  protected WebElement product;
  protected WebElement price;
  protected   String productName;
  protected   String productPrice;




   @BeforeClass
    public void setUp(){
       WebDriverManager.chromedriver().setup();

   }
   @BeforeMethod
    public void setUpMethod(){
       driver=new ChromeDriver();
      driver.get("http://automationpractice.com/index.php");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
        product= driver.findElement(By.linkText("Blouse"));

        productName=product.getText();
        price=driver.findElement(By.xpath("(//span[@class='price product-price'])[4]"));
        productPrice=price.getText();


   }
   @AfterMethod
    public void tearDownMethod() throws InterruptedException {

      //Thread.sleep(3000);
     //driver.quit();
   }

}
