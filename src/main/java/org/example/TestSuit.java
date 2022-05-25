package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit {


      protected static ChromeDriver driver;

         public static void main (String[] args){

            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");

          //   open the Chrome browser

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

          // URL
            driver.get("https://demo.nopcommerce.com/");



              //  click on register button
             clickOnElement(By.className("ico-register"));


             //select male and female

             driver.findElement(By.xpath("//input[@id='gender-female']"));

             //  enter firstname
             texttype(By.xpath("//input[@name='FirstName']"),"darshak");
            //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Autoamtion");

            //enter lastname
            texttype(By.id("LastName"),"goyani");

          //  driver.findElement(By.id("LastName")).sendKeys("LastNameTest");

             //select date of birth

             Select birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
             birthday.selectByIndex(11);

             Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
              birthMonth.selectByValue("june");

             Select birthyear = new Select(driver.findElement(By.name("DateOfBirthYear")));
              birthyear.selectByVisibleText("1976");


              //click on desktop
             clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

             //click on own product
             clickOnElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

             //click on email to friend
             clickOnElement(By.xpath("//button[normalize-space()'Email a friend']"));
             //enter email friend
             texttype(By.xpath("//input[@id='FriendEmail']"),"dvgoyani123@gmail.com");

             //click on send button
             clickOnElement(By.xpath("//button[contains(text(),'send email')]"));

             //check result

             String expected = "Your Massage has been sent.";
             String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
             Assert.assertEquals(expected,actualMessage,"Message has not been sent successfully");



            //email
            keyvalue(By.xpath("//input[@name='Email']"),"dvgoyani1 " +randomDate()+ "@gmail.com");
           // driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("dv00 07@gmail.com");

            //password
            texttype(By.xpath("//input[@name='Password']"),"darshak112345");
            //driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("darshak1234");

            //confirm password
            texttype(By.xpath("//input[@name='ConfirmPassword']"),"darshak112345");
           // driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("darshak1234");

           // register button
            getTextFromElement(By.xpath("//div/button[@type='submit']"));
          //  driver.findElement(By.xpath("//div/button[@type='submit']")).click();

             //Click on computer
             clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));}


             @Test
             public void userShouldBeableToSelectCurrencyInEuro(){

                 //click on currency
                 clickOnElement(By.id("customerCurrency"));

                 //Select currency
                 Select currency = new Select(driver.findElement(By.id("customerCurrency")));
                 currency.selectByVisibleText("Euro");

                 //scroll down on homepage and build own computer to check the price
                 clickOnElement(By.xpath("//a[normalize-space()='Build your own computer']"));

                 //user should be able to see 'euro' in front of the price
                 clickOnElement(By.xpath("//span[@id='price-value-1']"));

                 //Expected and actual result

                 String expectedCurrency ="€1022.00";
                 String actualCurrency = driver.findElement(By.xpath("//span[contains(text(),'€1022.00')]")).getText();
                 Assert.assertEquals(expectedCurrency,actualCurrency,"registration is not successful");



             }
              @Test
             public void userShouldBeAbleToaddProductinShoppingBasketSuccessfully(){

             //Click on computer
                   clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

              //click on desktops
              clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

              //click on build your own computer
                  clickOnElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));
              //click on processor and select ram 2.2Ghz
              driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
              Select processor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
              processor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

              //click on ram and select 2gb
                  driver.findElement(By.xpath("/label[contains(text(),'RAM')]"));
                  Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
                  ram.selectByVisibleText("2 GB");

               //select 320 gb
               clickOnElement(By.xpath("//input[@id='product_attritube_3_6']"));

               //select viata home from os
                  clickOnElement(By.xpath("//input[@id='product_attritube_4_8']"));
               //SELECT microsoft office
                  clickOnElement(By.xpath("//input[@id='product_attritube_5_10']"));
               //select software acrobat reader
                  clickOnElement(By.xpath("//input[@id='product_attritube_5_11']"));
               //select total commander
                  clickOnElement(By.xpath("//input[@id='product_attritube_5_12']"));

               //click on add to cart
                  clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
               //to verify product is in cart
                  clickOnElement(By.xpath("//input[@id='product_attribute_5_11']"));
               //select total command
                  clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
               //click on add to kart button
                  clickOnElement(By.xpath("//button[@id'add-to-cart-button-1']"));
               //verify the product is in basket or not
                  getTextFromElement(By.xpath("//span[@class=\"cart-label\"]"));

                  String expectedMessage ="The product has been added to your shopping cart";
                  String actualMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
                  Assert.assertEquals(expectedMessage,actualMessage,"Product has not been added to your cart");



         }



             public static void clickOnElement(By by) {
             driver.findElement(by).click();
       }
             public static void keyvalue(By by , String abc) {
             driver.findElement(by).sendKeys();
       }
             public static void texttype(By by , String text) {
             driver.findElement(by).sendKeys();
         }
             public static void getTextFromElement(By by) {
               driver.findElement(by).click();

            }
             public static String randomDate() {
                     Date date = new Date();
                     SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
                     return formatter.format(date);
         }
}