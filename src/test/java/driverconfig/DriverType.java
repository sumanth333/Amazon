package driverconfig;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.ie.InternetExplorerOptions;

import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.opera.OperaOptions;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.safari.SafariOptions;



import java.util.HashMap;



public enum DriverType implements DriverSetup{



    FIREFOX {

        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {

            String firefoxDriverPath = "src\\test\\java\\resources\\geckodriver.exe";

            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);


            FirefoxOptions options = new FirefoxOptions();

            options.merge(capabilities);

            options.setHeadless(HEADLESS);



            return new FirefoxDriver(options);

        }

    },

    CHROME {

        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {

            String chromeDriverPath = "src\\test\\java\\resources\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromeDriverPath);


            HashMap<String, Object> chromePreferences = new HashMap<>();

            chromePreferences.put("profile.password_manager_enabled", false);



            ChromeOptions options = new ChromeOptions();

            options.merge(capabilities);

            options.setHeadless(HEADLESS);

            options.addArguments("--no-default-browser-check");

            options.setExperimentalOption("prefs", chromePreferences);



            return new ChromeDriver(options);

        }

    },


    EDGE {

        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {

            String edgeDriverPath = "src\\test\\java\\resources\\edgedriver.exe";

            System.setProperty("webdriver.edge.driver", edgeDriverPath);

            EdgeOptions options = new EdgeOptions();

            options.merge(capabilities);



            return new EdgeDriver(options);

        }

    },

    OPERA {

        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {

            String operaDriverPath = "src\\test\\java\\resources\\operadriver.exe";

            System.setProperty("webdriver.opera.driver", operaDriverPath);

            OperaOptions options = new OperaOptions();

            options.merge(capabilities);



            return new OperaDriver(options);

        }

    };



    public final static boolean HEADLESS = Boolean.getBoolean("headless");

}