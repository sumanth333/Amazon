package tests;

import dataproviders.DataProviderSearchBooks;
import driverconfig.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.account.AmazonPage;
import pages.account.LoginPage;
import pages.shopping.BooksCategory;
import pages.shopping.CategorySee;
import pages.shopping.FilterBooks;
import pages.shopping.SearchBook;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class testingFramework {

    RemoteWebDriver driver;
    WebDriverWait wait;
    DriverFactory factory;

    @BeforeClass
    public void setUp() throws Exception {
        factory = new DriverFactory();
        driver = factory.getDriver();

        wait = new WebDriverWait(driver, 30);

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        AmazonPage homeObject = new AmazonPage(driver,wait);
        homeObject.clickAccount();

        LoginPage loginObject = new LoginPage(driver);
        loginObject.typeUserName("rgv7171@gmail.com");
        loginObject.clickContinue();

        loginObject.typePassword("RgvRgv#33");
        loginObject.clickSignInSubmit();

        BooksCategory category = new BooksCategory(driver,wait);
        category.hoverShopByCategory();
        category.hoverBooks();
        category.clickAllBooks();
        assertEquals("Books",driver.findElement(By.xpath("//span[@class = 'nav-search-label']")).getText());


    }
//    @Test (dataProvider = "Books", dataProviderClass = DataProviderSearchBooks.class)
//    public void searchBooks1(String bookName) {
//
//        System.out.println("data "+bookName);
//
//    }


        @Test (dataProvider = "Books", dataProviderClass = DataProviderSearchBooks.class)
    public void searchBooks(String bookName) {

     SearchBook searchObject = new SearchBook(driver,wait);
        searchObject.clearText();
        searchObject.typeBookName(bookName);
        searchObject.clickSearch();


        FilterBooks filterBooksObject = new FilterBooks(driver,wait);


//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='4 Stars & Up']")));
//        filterBooksObject.clickStars();

        filterBooksObject.clickPaperBack();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("editableBreadcrumbContent")));

        String actualString = driver.findElement(By.id("editableBreadcrumbContent")).getText();
        assertTrue(actualString.contains(bookName));

        CategorySee seeObject = new CategorySee(driver,wait);

        seeObject.clickSeeMore();
        seeObject.clickSeeLess();

    }
    @AfterClass
    public void closeDriver() {
        factory.quitDriver();
    }
}
