package com.qa.tutorialninja.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.tutorialsninja.Utilities.Utilities;

public class Test_Base {
    public WebDriver driver;
    public ChromeOptions options;
    public Properties prop;
    public FileInputStream ip;
    public Properties dataprop;
    public FileInputStream ip1;
    

    /**
     * The Test_Base class serves as the foundation for test classes. It holds a
     * WebDriver instance and provides a place to store utility methods or common
     * functionalities that can be reused across different test cases.
     * 
     * This class can be extended by other test cases, making it the parent class.
     * Test cases that extend this class inherit the WebDriver instance and any
     * utility methods defined here, promoting code reusability.
     * @throws IOException 
     */
    //Creating a constructor to read from the .properties which has the config data
    public Test_Base() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\tutorialsninja\\config\\config.properties");
        prop.load(ip);
        
        //creating new properties file for dataprop
        dataprop = new Properties();
        ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\tutorialninja\\Test_Data\\testData.properties"); 
        dataprop.load(ip1);
    }
    
    public WebDriver initializeBrowserAndOpenApplication(String browserName) {
        if (browserName.equals("chrome")) {
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browserName.contains("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.SCRIPT_TIME));
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
