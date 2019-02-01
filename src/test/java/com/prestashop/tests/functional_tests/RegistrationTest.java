package com.prestashop.tests.functional_tests;

import com.github.javafaker.Number;
import com.prestashop.utilties.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegistrationTest extends TestBase {
    String fakePhoneNumber, fakeAddress, fakeEmail, fakeEmailPassword,
            fakeFirstName, fakeLastName;

    @Test
    public void registrationTest() {
//  3. Click Sign in link
        WebElement homePageSignIn = driver.findElement(By.cssSelector("a.login"));
        homePageSignIn.click();
//4. Enter new valid email to the email field
        WebElement email = driver.findElement(By.cssSelector("input#email_create"));
        fakeEmail = faker.internet().emailAddress();
        email.sendKeys(fakeEmail);
//5. Click on Create Account
        driver.findElement(By.cssSelector("button#SubmitCreate")).click();
//6. Verify that that email link displays current email
        WebElement actualValue = driver.findElement(By.cssSelector("input#email"));
        actualValue.getAttribute("value");
        System.out.println(actualValue.isDisplayed());
//7. Fill out all the required steps
        //choose Title  Mr/Mrs
        driver.findElement(By.cssSelector("div#uniform-id_gender1")).click();
        //fill first name
        driver.findElement(By.cssSelector("input#customer_firstname")).sendKeys("rahman");
        //fill last name
        driver.findElement(By.cssSelector("input#customer_lastname")).sendKeys("kawul");
        //password
        WebElement fakePassword = driver.findElement(By.cssSelector("input#passwd"));
        fakeEmailPassword = faker.internet().password();
        fakePassword.sendKeys(fakeEmailPassword);
        //choose Date of Birth
        WebElement days = driver.findElement(By.id("days"));//days
        Select selectDays = new Select(days);
        selectDays.selectByValue("17");

        WebElement months = driver.findElement(By.id("months"));//months
        Select selectMonth = new Select(months);
        selectMonth.selectByValue("5");

        WebElement year = driver.findElement(By.id("years"));//years
        Select selectYear = new Select(year);
        selectYear.selectByValue("1985");

        //fill first name 'Under the Your Address'
        WebElement fakeFname = driver.findElement(By.cssSelector("input#firstname"));
        fakeFirstName = faker.name().firstName();
        fakeFname.sendKeys(fakeFirstName);
        //fill last name
        WebElement fakeLname = driver.findElement(By.cssSelector("input#lastname"));
        fakeLastName = faker.name().lastName();
        fakeLname.sendKeys(fakeLastName);
        //address
        driver.findElement(By.cssSelector("input#address1")).sendKeys("Dawan street");
        //city
        driver.findElement(By.cssSelector("input#city")).sendKeys("falls church");
        //select state
        WebElement selectState = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select = new Select(selectState);
        select.selectByVisibleText("Virginia");
        //zip code
        WebElement zipCode = driver.findElement(By.cssSelector("input#postcode"));
        zipCode.sendKeys("22201");
        //select country
        WebElement selectCountry = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select selectCoun = new Select(selectCountry);
        selectCoun.selectByVisibleText("United States");
        //phone number
        WebElement mobileNumber = driver.findElement(By.cssSelector("input#phone_mobile"));
        fakePhoneNumber = faker.phoneNumber().cellPhone();
        mobileNumber.sendKeys(fakePhoneNumber);
        //address alias
        WebElement alisAdrees = driver.findElement(By.cssSelector("input#alias"));
        fakeAddress = faker.address().streetAddress();
        alisAdrees.sendKeys(fakeAddress);
        //8. Click on Register
        driver.findElement(By.cssSelector("button#submitAccount")).click();
//9. Verify that correct first and last name is displayed correctly on top right
        WebElement fullName = driver.findElement(By.xpath("//span[text()='rahman kawul']"));
        System.out.println(fullName.isDisplayed());
//        10. Click on My personal information
        driver.findElement(By.xpath("//span[.='My personal information']")).click();
//        11. Verify that personal information is displayed correctly
        WebElement actualFirstName = driver.findElement(By.cssSelector("#firstname"));
        actualFirstName.getAttribute("value");
        System.out.println(actualFirstName.isDisplayed());
        WebElement actualLastName = driver.findElement(By.cssSelector("input#lastname"));
        actualFirstName.getAttribute("value");
        System.out.println(actualLastName.isDisplayed());
//        12. Click on Back to your account
        driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small'])[2]")).click();
//        13. Click on My addresses
        driver.findElement(By.xpath("//span[.='My addresses']")).click();
        //verify that address information is displayed correctly
        WebElement displayedAddress = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
        Assert.assertTrue(displayedAddress.isDisplayed());
//        14. Click on sign out link
        driver.findElement(By.cssSelector("a.logout")).click();
//        15. Login using the email and password if the current user
        driver.findElement(By.cssSelector("input#email")).sendKeys(fakeEmail);
        driver.findElement(By.cssSelector("input#passwd")).sendKeys(fakeEmailPassword);
        driver.findElement(By.cssSelector("button#SubmitLogin")).click();
//        16. Verify that correct first and last name is displayed correctly on top right
        WebElement lastFullName = driver.findElement(By.xpath("//span[text()='rahman kawul']"));
        System.out.println(lastFullName.isDisplayed());
    }

    //  Error Message Validation: First name
    @Test
    public void errorMessageValidationFirstnameTest() {
        //3. Click Sign in link
        WebElement homePageSignIn = driver.findElement(By.cssSelector("a.login"));
        homePageSignIn.click();
        //4. Enter new valid email to the email field
        WebElement email = driver.findElement(By.cssSelector("input#email_create"));
        fakeEmail = faker.internet().emailAddress();
        email.sendKeys(fakeEmail);
        //5. Click on Create Account
        driver.findElement(By.cssSelector("button#SubmitCreate")).click();
        //6. Fill all the required steps except for first name
        driver.findElement(By.cssSelector("input#customer_lastname")).sendKeys("kawul");
        //password
        WebElement fakePassword = driver.findElement(By.cssSelector("input#passwd"));
        fakeEmailPassword = faker.internet().password();
        fakePassword.sendKeys(fakeEmailPassword);
        //choose Date of Birth
        WebElement days = driver.findElement(By.id("days"));//days
        Select selectDays = new Select(days);
        selectDays.selectByValue("17");

        WebElement months = driver.findElement(By.id("months"));//months
        Select selectMonth = new Select(months);
        selectMonth.selectByValue("5");

        WebElement year = driver.findElement(By.id("years"));//years
        Select selectYear = new Select(year);
        selectYear.selectByValue("1985");

        //fill first name 'Under the Your Address'
        WebElement fakeFname = driver.findElement(By.cssSelector("input#firstname"));
        fakeFirstName = faker.name().firstName();
        fakeFname.sendKeys(fakeFirstName);
        //fill last name
        WebElement fakeLname = driver.findElement(By.cssSelector("input#lastname"));
        fakeLastName = faker.name().lastName();
        fakeLname.sendKeys(fakeLastName);
        //address
        driver.findElement(By.cssSelector("input#address1")).sendKeys("Dawan street");
        //city
        driver.findElement(By.cssSelector("input#city")).sendKeys("falls church");
        //select state
        WebElement selectState = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select = new Select(selectState);
        select.selectByVisibleText("Virginia");
        //zip code
        WebElement zipCode = driver.findElement(By.cssSelector("input#postcode"));
        zipCode.sendKeys("22201");
        //select country
        WebElement selectCountry = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select selectCoun = new Select(selectCountry);
        selectCoun.selectByVisibleText("United States");
        //phone number
        WebElement mobileNumber = driver.findElement(By.cssSelector("input#phone_mobile"));
        fakePhoneNumber = faker.phoneNumber().cellPhone();
        mobileNumber.sendKeys(fakePhoneNumber);
        //address alias
        WebElement alisAdrees = driver.findElement(By.cssSelector("input#alias"));
        fakeAddress = faker.address().streetAddress();
        alisAdrees.sendKeys(fakeAddress);
        //8. Click on Register
        driver.findElement(By.cssSelector("button#submitAccount")).click();
//8. Verify that error message firstname is required. is displayed
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol//li")).isDisplayed());
    }

    //    Cart Details
    @Test
    public void cartDetailsTest1() throws InterruptedException {
        //3. Click on any product that is not on sale
        product.click();
//4. Enter a random quantity between 2 and 5
        WebElement quantityRandom1 = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]"));
        Random rn1 = new Random();

        int temp1 = rn1.nextInt(4);
        while (temp1 < 4) {
            quantityRandom1.click();
            temp1++;
        }
//5. Select a different size
        WebElement selectSize = driver.findElement(By.cssSelector("select#group_1"));
        Select select = new Select(selectSize);
        select.selectByValue("2");
//6. Click on add to cart
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();
        //7. Verify confirmation message Product successfully added to your shopping cart
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
        confirmationMessage.click();
        String expectedMassage = "Product successfully added to your shopping cart";
        String actualMassage = confirmationMessage.getText();
        Assert.assertEquals(expectedMassage, actualMassage);
//8. Dismiss the confirmation window by clicking on the x icon
        WebElement dismissClick = driver.findElement(By.xpath("//body[@id='product']"));
        dismissClick.click();
//9. Click on the company logo
        Thread.sleep(1000);
        driver.findElement(By.id("header_logo")).click();
//10. Click on any product that is on sale
    }

    @Test
    public void cartDetailsTest2() throws InterruptedException {
        product.click();
//11. Enter a random quantity between 2 and 5
        WebElement quantityRandom2 = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]"));
        Random rn2 = new Random();

        int temp2 = rn2.nextInt(4);
        while (temp2 < 4) {
            quantityRandom2.click();
            temp2++;
        }
        //12. Select a different size
        WebElement selectAnotherSize = driver.findElement(By.cssSelector("select#group_1"));
        Select select2 = new Select(selectAnotherSize);
        select2.selectByValue("3");
//13. Click on add to cart
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();
//14. Verify confirmation message Product successfully added to your shopping cart
        WebElement confirmationMessage1 = driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
        confirmationMessage1.click();
        String expectedMassage1 = "Product successfully added to your shopping cart";
        String actualMassage1 = confirmationMessage1.getText();
        Assert.assertEquals(expectedMassage1, actualMassage1);
//15. Dismiss the confirmation window by clicking on the x icon
        WebElement dismissClick = driver.findElement(By.xpath("//body[@id='product']"));
        dismissClick.click();
//16. Hover over the Cart icon
        WebElement hoverMenue=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverMenue).build().perform();
        Thread.sleep(1500);
//17. Verify that correct total is displayed
    WebElement totalPrice=driver.findElement(By.xpath("//span[.='Total']/../span[1]"));
    System.out.println(totalPrice.getText());
    System.out.println(totalPrice.isDisplayed());
//18. Verify that total is correct based on the price and item count of the
// products you added to cart. (Shipping is always $2)
        //in order to get correct price and item count of the product we need to click 'Check Out' button after
        //we will get all the base information.
    driver.findElement(By.cssSelector("a#button_order_cart")).click();
        WebElement correctPrice=driver.findElement(By.xpath("//tfoot//tr"));
        System.out.println(correctPrice.getText());
     //verify that (Shipping is always $2)
     WebElement shipping=driver.findElement(By.cssSelector("[class=cart_total_delivery]"));
     System.out.println("Expected shipping: "+shipping.getText());
     Assert.assertTrue(shipping.isDisplayed());
    }
}



