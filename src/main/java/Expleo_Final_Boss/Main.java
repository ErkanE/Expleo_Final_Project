package Expleo_Final_Boss;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main (String[]args){

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        String baseUrl = "http://weather.news24.com/";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table/tbody/tr[3]/td/div[2]/div[1]/a[2]")).click();
        driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[3]/td/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div/div/div[3]/div[1]/span")).click();
        WeatherNews24PageObject News24PageObject = PageFactory.initElements(driver, WeatherNews24PageObject.class);
        System.out.println("Weather News 24 Forecast:");
        News24PageObject.printBoth();


        String baseUrl1 = "https://www.accuweather.com/en/za/johannesburg/305448/daily-weather-forecast/305448";
        driver.get(baseUrl1);
        AccuweatherPageObject AccuweatherPageObject1 = PageFactory.initElements(driver, AccuweatherPageObject.class);
        System.out.println("Accuweather Forecast:");
        AccuweatherPageObject1.printBoth();
    }
}
