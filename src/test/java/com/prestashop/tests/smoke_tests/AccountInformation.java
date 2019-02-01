package com.prestashop.tests.smoke_tests;

import com.prestashop.utilties.Driver;
import com.prestashop.utilties.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountInformation extends TestBase {



//    Login: my account
    @Test
    public void logIn() {
        WebElement homePageSignIn = driver.findElement(By.cssSelector("a.login"));
        homePageSignIn.click();
        WebElement userName =driver.findElement(By.cssSelector("input#email"));
        userName.sendKeys("abdurahman7777@outlook.com");
        WebElement password=  driver.findElement(By.cssSelector("input#passwd"));
        password.sendKeys("rahman123");
        WebElement signIn = driver.findElement(By.id("SubmitLogin"));
        signIn.click();
        //4. Verify that title contains My account
        String expectedTitle="My account";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5. Verify that account holder full name is displayed next to the Sign out link
        WebElement expectedAccountHolderName=driver.findElement(By.cssSelector("[title='View my customer account']"));
        expectedAccountHolderName.getText();
        System.out.println("Expected user name: "+expectedAccountHolderName.getText());
        Assert.assertTrue(expectedAccountHolderName.isDisplayed());

    }


//    Login: My personal information
    @Test
    public void personalInfoTest() {
        WebElement homePageSignIn = driver.findElement(By.cssSelector("a.login"));
        homePageSignIn.click();
        WebElement userName =driver.findElement(By.cssSelector("input#email"));
        userName.sendKeys("abdurahman7777@outlook.com");
        WebElement password=  driver.findElement(By.cssSelector("input#passwd"));
        password.sendKeys("rahman123");
        WebElement signIn = driver.findElement(By.id("SubmitLogin"));
        signIn.click();
//6. Click on My personal information button
  driver.findElement(By.xpath("//span[.='My personal information']")).click();
//7. Verify title contains Identity
     String expectedTitle="Identity";
     String actualTitle=driver.getTitle();
     Assert.assertTrue(actualTitle.contains(expectedTitle));
//8. Verify that first name and last name matches the full name on top
    String fullNameOnTop=driver.findElement(By.cssSelector("[title='View my customer account']")).getText();
    String  firstName=driver.findElement(By.cssSelector("input#firstname")).getAttribute("value");
    String lastName=driver.findElement(By.cssSelector("input#lastname")).getAttribute("value");
    System.out.println("Fist and last name: "+firstName+" "+lastName+" | "+"Full name on top :"+fullNameOnTop);
    Assert.assertTrue(fullNameOnTop.contains(firstName));
    Assert.assertTrue(fullNameOnTop.contains(lastName));
//9. Click on Save button
        driver.findElement(By.name("submitIdentity")).click();
//10. Verify error message “The password you entered is incorrect.”
      String expectedErrorMassage="The password you entered is incorrect." ;
      String actualErrorMassage=driver.findElement(By.xpath("//li[.='The password you entered is incorrect.']")).getText();
      Assert.assertEquals(expectedErrorMassage,actualErrorMassage);
     //11. Click on Back to your account
        driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small'])[2]")).click();
    //12. Verify that title contains My account
       String expTitle="My account";
       String actTitle=driver.getTitle();
       Assert.assertTrue(actTitle.contains(expTitle));
    }
//    Login: My addresses
   @Test
   public void myAdressTest() {
       WebElement homePageSignIn = driver.findElement(By.cssSelector("a.login"));
       homePageSignIn.click();
       WebElement userName = driver.findElement(By.cssSelector("input#email"));
       userName.sendKeys("abdurahman7777@outlook.com");
       WebElement password = driver.findElement(By.cssSelector("input#passwd"));
       password.sendKeys("rahman123");
       WebElement signIn = driver.findElement(By.id("SubmitLogin"));
       signIn.click();
//13. Click on My addresses
       driver.findElement(By.xpath("//span[.='My addresses']")).click();
//14. Click on Add a new address
       driver.findElement(By.xpath("//span[.='Add a new address']")).click();
//15. Verify that first name and last name matches the full name on top
       String fullNameOnTop=driver.findElement(By.cssSelector("[title='View my customer account']")).getText();
       String  firstName=driver.findElement(By.cssSelector("input#firstname")).getAttribute("value");
       String lastName=driver.findElement(By.cssSelector("input#lastname")).getAttribute("value");
       System.out.println("Fist and last name: "+firstName+" "+lastName+" | "+"Full name on top :"+fullNameOnTop);
       Assert.assertTrue(fullNameOnTop.contains(firstName));
       Assert.assertTrue(fullNameOnTop.contains(lastName));
//16. Delete the first name
     driver.findElement(By.cssSelector("input#firstname")).clear();
//17. Click save
      driver.findElement(By.id("submitAddress")).click();
//18. Verify error message “first name is required.”//b[.='firstname']
     String expectedErrorMsg="firstname is required." ;
     String actualErrorMsg=driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol//li[1]")).getText();
       System.out.println("Expected error massage: "+expectedErrorMsg+"\nActual  error massage: "+actualErrorMsg);
       Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
   }
}
