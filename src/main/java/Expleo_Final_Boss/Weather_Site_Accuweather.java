package Expleo_Final_Boss;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Weather_Site_Accuweather {

    private static String Temp_Temperature;
    private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    Weather_Site_News24 news24 = new Weather_Site_News24();

    @Test
    public static AccuweatherPageObject getAccuweather() {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            String baseUrl = "https://www.accuweather.com/en/za/johannesburg/305448/daily-weather-forecast/305448";
            driver.get(baseUrl);


            baseUrl = "https://www.accuweather.com/en/za/johannesburg/305448/daily-weather-forecast/305448";
            driver.get(baseUrl);
            AccuweatherPageObject AccuweatherPageObject1 = PageFactory.initElements(driver, AccuweatherPageObject.class);

            // Get Max Temp for Day 1
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMaxTemp(0, Integer.parseInt(Temp_Temperature.substring(1,3)));
            // Get Min Temp for Day 1
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMinTemp(0, Integer.parseInt(Temp_Temperature.substring(3)));

            // Get Max Temp for Day 2
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMaxTemp(1, Integer.parseInt(Temp_Temperature.substring(1,3)));
            // Get Min Temp for Day 2
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMinTemp(1, Integer.parseInt(Temp_Temperature.substring(3,5)));

            // Get Max Temp for Day 3
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMaxTemp(2, Integer.parseInt(Temp_Temperature.substring(1,3)));
            // Get Min Temp for Day 3
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMinTemp(2, Integer.parseInt(Temp_Temperature.substring(3,5)));

            // Get Max Temp for Day 4
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[5]/a[1]/div[2]/span[1]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMaxTemp(3, Integer.parseInt(Temp_Temperature.substring(1,3)));
            // Get Min Temp for Day4
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[5]/a[1]/div[2]/span[2]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMinTemp(3, Integer.parseInt(Temp_Temperature.substring(3,5)));

            // Get Max Temp for Day 5
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMaxTemp(4, Integer.parseInt(Temp_Temperature.substring(1,3)));
            // Get Min Temp for Day 5
            Temp_Temperature = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getAttribute("innerHTML");
            AccuweatherPageObject1.addMinTemp(4, Integer.parseInt(Temp_Temperature.substring(3,5)));

            // Print Results
            System.out.println("Accuweather Forecast:");
            AccuweatherPageObject1.printBoth();
            driver.quit();

            return AccuweatherPageObject1;
        }

    @After
    public void tearDown() throws Exception {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}





