package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;

    By search = By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input");

  @Given("^Open the chrome and start the application$")
  public void open_chrome_browser() throws Throwable {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe" );
  	driver = new ChromeDriver();
  	driver.get("https://www.myntra.com");
  	//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
  	driver.manage().window().maximize();
  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  @Then("^Search the mobile cases and add it to the bag and place order$")
  public void search_the_moile_cases_and_add_it_to_the_bag_and_place_rder() throws Throwable {
	  driver.findElement(search).sendKeys("mobile cases");
	    Thread.sleep(2000);
	    driver.findElement(search).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/ul/li[6]/label")).click();
	 Thread.sleep(2000);
	    WebElement l = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[3]/a/div[1]/div"));

	    Actions a = new Actions(driver);
	    a.moveToElement(l).click().perform();
	    Thread.sleep(2000);

	    Set<String> windowhandles = driver.getWindowHandles();
	    Iterator<String> iterator = windowhandles.iterator();
	    String parent = iterator.next();
	    String child = iterator.next();
	    driver.switchTo().window(child);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,250)", "");

	    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")).click();
	    Thread.sleep(2000);
	   
	    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/a")).click();
	    
	 Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"cartItemsList\"]/div/div/div/div[2]/div[1]/div/div[1]")).click();
	   
	    Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"appContent\"]/div/div/div/div/div[2]/div[3]/button/div")).click();

	    Thread.sleep(2000);
	    }
  
  @When("^I enter the valid mobile number and valid OTP$")
  public void enter_valid_username_and_OTP() throws Throwable {
	  String mobileNumber = "9131503109";
	    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[1]/input")).clear();
	    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[1]/input")).sendKeys(mobileNumber);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[3]")).click();
	    Thread.sleep(5000);
	   
  }

 @Then("^Close the browser$")
  public void close_the_browser() throws Throwable {
	 driver.quit();
 }
  }


