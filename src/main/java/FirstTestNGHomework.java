import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestNGHomework {
    WebDriver driver;

    @Test(priority = 1)
    void openBrowser(){
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    void category(){
        System.out.println("Select Computer");
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();


    }

    @Test(priority = 3)
    void selection(){
        System.out.println("Select category: Desktops");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
    }

    @Test(priority = 4)
    void addToCart(){
        System.out.println("Add to cart");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();

    }

    @Test(priority = 5)
    void goToCart(){
        System.out.println("Go to cart");
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]")).click();


    }

    @Test(priority = 6)
    void updateQuantity(){
        System.out.println("Update qty to 3");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys("3");
    }

    @Test(priority = 7)
    void updateCart(){
        System.out.println("Update shopping cart");
        driver.findElement(By.id("updatecart")).click();
    }

    @Test(priority = 8)
    void acceptTerms(){
        System.out.println("agree with terms");
        driver.findElement(By.id("termsofservice")).click();
    }

    @Test(priority = 9)
    void checkout(){
        System.out.println("Checkout");
        driver.findElement(By.id("checkout")).click();
    }

    @Test(priority = 10)
    void guestCheckout(){
        System.out.println("Checkout as guest");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 11)
    void billingInfo(){
        System.out.println("Fill in billing details");
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Philip");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Jones");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("tester@gmail.com");

        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(country);
        select.selectByVisibleText("United Kingdom");


        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("New York");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("12, American Street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("10001");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();

    }

    @Test(priority = 12)
    void shipping(){
        System.out.println("Select shipping method");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
    }

    @Test(priority = 13)
    void payment(){
        System.out.println("Select payment method");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();
    }

    @Test(priority = 14)
    void confirmPayment(){
        System.out.println("Confirm payment information");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
    }

    @Test(priority = 15)
    void confirmOrder(){
        System.out.println("Confirm order");
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
    }
}
