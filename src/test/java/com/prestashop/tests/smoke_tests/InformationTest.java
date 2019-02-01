package com.prestashop.tests.smoke_tests;

import com.prestashop.utilties.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InformationTest extends TestBase {


    @Test
    public void ProductInfoTest(){
     //2. Click on any product
      product.click();
      // 3. Verify that same name and price displayed as on the home page
      String homePageName=driver.findElement(By.xpath("//h1[.='Blouse']")).getText();
      String productHomePagePrice=driver.findElement(By.cssSelector("span#our_price_display")).getText();
        System.out.println("Home page produce name: "+productName+
                " | "+"Product page name: "+homePageName);

        System.out.println("Home page produce price: "+productPrice+
                " | "+"Product page price: "+productHomePagePrice);
        Assert.assertEquals(productName,homePageName);
        Assert.assertEquals(productPrice,productHomePagePrice);
    }
//    Product information - details:
    @Test
    public void detailTest() {
        //click product
        product.click();
       //4. that default quantity is 1
     WebElement defaultValueQuantity=driver.findElement(By.id("quantity_wanted"));
     String expectedDefaultQuantity="1";
     String actualDefaultQuantity=defaultValueQuantity.getAttribute("value");
     System.out.println("Expected default quantity is: "+expectedDefaultQuantity+
                "\nActual default value is: "+actualDefaultQuantity);
        Assert.assertEquals(expectedDefaultQuantity,actualDefaultQuantity);
        // 5. Verify that default size is S
        WebElement size=driver.findElement(By.id("group_1"));
        Select select=new Select(size);
        String expectedSize="S";
        String actualSize=select.getFirstSelectedOption().getText();
        System.out.println("Expected default size is: "
                +expectedSize+"\nActual default size is: "+actualSize);
        Assert.assertEquals(expectedSize,actualSize);
        //6. Verify that size options are S, M, L
        List<WebElement> sizeOptions=select.getOptions();
        for (WebElement allOptions:sizeOptions ){
            System.out.println("Expected size option: " +allOptions.getText());
         Assert.assertTrue(sizeOptions.contains(allOptions));


            }
        }


//Product information – Add to cart:
   @Test
   public void addToCartTest() {
        //click product
        product.click();
        // 7. Click on Add to cart
    driver.findElement(By.cssSelector("button.exclusive")).click();
//8. Verify confirmation message “Product successfully added to your shopping cart”
   String expectedMsg="Product successfully added to your shopping cart";
   WebElement actualMsg=driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
   actualMsg.click();
   String actualMassage=actualMsg.getText();
       System.out.println("Expected Massage: "+expectedMsg+" | "+"Actual Massage: "+actualMsg.getText());
       Assert.assertEquals(expectedMsg,actualMassage);
       // 9.Verify that default quantity is 1
       String expectedQuantity="1";
       String actualQuantity=driver.findElement(By.id("layer_cart_product_quantity")).getText();
       System.out.println("Expected quantity in the cart should be: "+expectedQuantity+" | "+"Actual quantity in the cart is: "+actualQuantity);
       Assert.assertEquals(expectedQuantity,actualQuantity);
       //10. Verify that default size is S
       String expectedSize="S";
       String actualSize=driver.findElement(By.id("layer_cart_product_attributes")).getText();
       System.out.println("Expected size in the cart: "+expectedSize +" | "+"Actual default siz is: "+actualSize);
      // Assert.assertTrue(actualSize.substring(actualSize.indexOf(","),actualSize.length()).contains(expectedSize));
        Assert.assertTrue(actualSize.contains(expectedSize));
      //11. Verify that same name and price displayed as on the home page
       String cartProductName =driver.findElement(By.id("layer_cart_product_title")).getText();
       String cartProductPrice=driver.findElement(By.id("layer_cart_product_price")).getText();
       System.out.println("Product name: "+cartProductName+"\nProduct price: "+cartProductPrice);
       Assert.assertEquals(productName,cartProductName);
       Assert.assertEquals(productPrice,cartProductPrice);



   }


    }

