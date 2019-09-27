package Expleo_Final_Boss;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.fail;


public class Weather_Site_News24 {
        private String Temp_Temperature;
        private String baseUrl;
        private WebDriver driver;
        private StringBuffer verificationErrors = new StringBuffer();
        WeatherNews24PageObject News24PageObject = new WeatherNews24PageObject();

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void getWeatherNews24Forecast() throws Exception {

            baseUrl = "http://weather.news24.com/";
            driver.get(baseUrl);
            driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table/tbody/tr[3]/td/div[2]/div[1]/a[2]")).click();
            driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr[3]/td/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div/div/div[3]/div[1]/span")).click();
            WeatherNews24PageObject News24PageObject = PageFactory.initElements(driver, WeatherNews24PageObject.class);

            // Get Max Temp for Day 1
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[4]")).getAttribute("innerHTML");
            News24PageObject.addMaxTemp(0, Integer.parseInt(Temp_Temperature.substring(0,2)));
            // Get Min Temp for Day 1
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getAttribute("innerHTML");
            News24PageObject.addMinTemp(0, Integer.parseInt(Temp_Temperature.substring(0,1)));

            // Get Max Temp for Day 2
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getAttribute("innerHTML");
            // System.out.print("WN24 Day 2 Max: " + output);
            News24PageObject.addMaxTemp(1, Integer.parseInt(Temp_Temperature.substring(0,2)));
            // Get Min Temp for Day 2
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getAttribute("innerHTML");
            // System.out.println("\tMin: " +output);
            News24PageObject.addMinTemp(1, Integer.parseInt(Temp_Temperature.substring(0, 1)));

            // Get Max Temp for Day 3
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getAttribute("innerHTML");
            News24PageObject.addMaxTemp(2, Integer.parseInt(Temp_Temperature.substring(0,2)));
            // Get Min Temp for Day 3
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getAttribute("innerHTML");
            News24PageObject.addMinTemp(2, Integer.parseInt(Temp_Temperature.substring(0,2)));

            // Get Max Temp for Day 4
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getAttribute("innerHTML");
            News24PageObject.addMaxTemp(3, Integer.parseInt(Temp_Temperature.substring(0,2)));
            // Get Min Temp for Day4
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getAttribute("innerHTML");
            News24PageObject.addMinTemp(3, Integer.parseInt(Temp_Temperature.substring(0,2)));

            // Get Max Temp for Day 5
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getAttribute("innerHTML");
            News24PageObject.addMaxTemp(4, Integer.parseInt(Temp_Temperature.substring(0,2)));
            // Get Min Temp for Day 5
            Temp_Temperature = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getAttribute("innerHTML");
            News24PageObject.addMinTemp(4, Integer.parseInt(Temp_Temperature.substring(0,2)));

            // Print Results
            System.out.println("Weather News 24 Forecast:");
            News24PageObject.printBoth();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }


}
