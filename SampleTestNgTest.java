package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePage;

import java.util.List;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverPool;
import java.util.concurrent.TimeUnit;

public class SampleTestNgTest extends TestNgTestBase {

    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(baseUrl);
    }

    @Test
  /*  public void testHomePageHasAHeader() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Go to Event list')] "));
        System.out.println("Name of link: " + element.getText());
        element.click();

            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            element = driver.findElement(By.xpath("//span[contains(text(),'Filters')]"));
            System.out.println("Name of the button for filtering: " + element.getText());
            String name_of_button = element.getText();

            Assert.assertTrue(name_of_button.equals("Filters"));

            /////////////////////////////////////////////////////////////////////////////////////////////////////

            element = driver.findElement(By.xpath("//mat-icon[contains(text(),'lock')]"));
            System.out.println("Login button: " + element.getText());
            element.click();


            element = driver.findElement(By.xpath("//span[contains(text(),\"Still don't have account?\")]"));
            System.out.println("Text on the login window: " + element.getText());
            String text_of_login_window = element.getText();

            element = driver.findElement(By.xpath("//mat-dialog-container[@id=\'mat-dialog-0\']"));

            Assert.assertTrue(text_of_login_window.equals("Still don't have account?"));

            element = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
            System.out.println("Text on the login window: " + element.getText());


            List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='mat-input-infix mat-form-field-infix']/input"));
            element = webElements.get(0);
            System.out.println("class: " + element.getAttribute("class"));
            element.click();
            element.clear();
            element.sendKeys("vigla@meta.com");

            element = webElements.get(1);
            element.click();
            element.clear();
            element.sendKeys("333333");

        element = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        element.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

      element = driver.findElement(By.xpath("//h1[@class='gorisontal-center']"));
     System.out.println("Name of the button in the Find Event page: " + element.getText());
     String name_of_buttons = element.getText();
     Assert.assertTrue(name_of_buttons.equals("Find event"));

     element = driver.findElement(By.xpath("//img[@height='24']"));
     System.out.println("Name of the add event button: " + element.getText());
     String add_event_button = element.getText();
    element.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


            element = driver.findElement(By.xpath("//div[@class='mat-select-value']"));
            System.out.println("Link Name: " + element.getText());
            element.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    private WebElement waitUntilElementIsLodedCustomTime(By by, int time, String error_message) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }
    }*/
    public void testHomePageHasAHeader() {

        WebElement loginLink = this.waitUntilElementIsLodedCustomTime(
                By.xpath("//span[contains(text(),'Login')]"),
                40,
                "Login link was not loaded");

        loginLink.click();
        WebElement buttonLogin = waitUntilElementIsLodedCustomTime(
                By.xpath("//span[contains(text(),'Log in')]"),
                40,
                "Login field element was not loaded");

        List<WebElement> webElements
                = driver.findElements(By.xpath("//div [@class='mat-input-infix mat-form-field-infix']/input"));

        WebElement fieldLogin = webElements.get(0);
        fieldLogin.click();
        fieldLogin.sendKeys("vigla@meta.com");

        WebElement fieldPassword = webElements.get(1);
        fieldPassword.click();
        fieldPassword.sendKeys("333333");

        buttonLogin.click();

        WebElement filterCities = waitUntilElementIsLodedCustomTime(
                By.xpath("//div[@class='mat-select-value']"),
                40,
                "Filter Cities element was not loaded");

        filterCities.click();

    }

    @Test
    public void wrongPassword() {
        WebElement loginLink = this.waitUntilElementIsLodedCustomTime(By.xpath("//span[contains(text(),'Login')]"), 40, "Login link was not loaded");

        loginLink.click();
        WebElement buttonLogin = waitUntilElementIsLodedCustomTime(By.xpath("//span[contains(text(),'Log in')]"),
                60, "Login field element was not loaded");

        List<WebElement> webElements = driver.findElements(By.xpath("//div [@class='mat-input-infix mat-form-field-infix']/input"));

        WebElement fieldLogin = webElements.get(0);
        fieldLogin.click();
        fieldLogin.sendKeys("vigla@meta.com");

        WebElement fieldPassword = webElements.get(1);
        fieldPassword.click();
        fieldPassword.sendKeys("222222");
        buttonLogin.click();

        WebElement wrongMassage = this.waitUntilElementIsLodedCustomTime
                (By.xpath("//*[contains(text(),'Wrong authorization, login or password')]"),
                        60,"Wrong massage was not displayed");
        WebElement cancelButton = this.waitUntilElementIsLodedCustomTime(
                By.xpath("//button[@type='button']"),40, "Cancel button was not found");
        cancelButton.click();
        WebElement goToEventList  = this.waitUntilElementIsLodedCustomTime(
                By.xpath("//span[contains(text(),'Go to Event list')]"),40,"Button 'Go to EventList' is not visible");

       // Assert.assertTrue(goToEventList.equals("Go to Event list"));


        }

        @Test
        public void createAccount() {
        WebElement createAccountLink = this.waitUntilElementIsLodedCustomTime
                (By.xpath("//span[contains(text(),'Create Account')]"),40,"Create Account button is not found");
        createAccountLink.click();

        WebElement massage_is_there_an_account = this.waitUntilElementIsLodedCustomTime(
                By.xpath("//span[contains(text(),'Has already account?')]"),
                50,"Massage is there an account was not displayed");

            List<WebElement> webElements = driver.findElements(
                    By.xpath("//div[@class='mat-input-infix mat-form-field-infix']/input"));
            WebElement fieldLogin = webElements.get(0);
            fieldLogin.click();
            fieldLogin.clear();
            fieldLogin.sendKeys("cheburashka@gmail.com");

            WebElement fieldPassword = webElements.get(1);
            fieldPassword.click();
            fieldPassword.clear();
            fieldPassword.sendKeys("123123");

            WebElement fieldRepeatPassword = webElements.get(2);
            fieldRepeatPassword.click();
            fieldRepeatPassword.clear();
            fieldRepeatPassword.sendKeys("123123");

            WebElement registrationButton = this.waitUntilElementIsLodedCustomTime(By.xpath("//span[contains(text(),'Registration')]"),
                   40,"Registration button is not activity");
            registrationButton.click();

            WebElement regestrationText = this.waitUntilElementIsLodedCustomTime(By.xpath("//h1[@class='classCentr']"),
            50,"Registration page is not open");
            System.out.println("Text in the registration page: " + regestrationText.getText());
            String text_in_the_registration_page = regestrationText.getText();

            Assert.assertTrue(text_in_the_registration_page.equals ("Registration"));



    }


    private WebElement waitUntilElementIsLodedCustomTime(By by, int time, String error_message) {
      WebDriverWait wait = new WebDriverWait(driver, time);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

}