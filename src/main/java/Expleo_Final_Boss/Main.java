package Expleo_Final_Boss;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main (String[]args) throws Exception{

        WeatherNews24PageObject News24PageObject1 = Weather_Site_News24.getWeatherNews24Forecast();
        System.out.println("Weather News 24 Forecast:");


        AccuweatherPageObject accuweatherPageObject = Weather_Site_Accuweather.getAccuweather();
        System.out.println("Accuweather Forecast:");


    }
}
