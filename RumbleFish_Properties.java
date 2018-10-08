package RumbleFishPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RumbleFish_Properties {
	
	static WebDriver driver = new ChromeDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 10);

	//pages
	static String RedditPage = "https://www.reddit.com/";

	//login page fields
	private static String loginfield = "//*[@id=\\\"loginUsername\\\"]";
	private static String loginbutton = "\"/html/body/div/div/div[2]/div/form/fieldset[5]/button\"";
	private static String passwordfield = "loginPassword";
	private static String loginpagebtn = "//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div/div[1]/header/div/div[2]/div[2]/div[1]/a[1]";
	static String loginpageurl = driver.findElement(By.xpath(loginpagebtn)).getAttribute("href");
	
	//user credentials
	private static String userlogin = "carlopezhuesca";
	private static String userpswd = "testpswd";
	
	//others
	private static String searchbar = "header-search-bar";

	
	public static void main(String[] args) {

	}


	public static void LaunchChromeAndOpenRedditPage() {
		// TODO Auto-generated method stub
		driver.get(RumbleFish_Properties.RedditPage);
		System.out.print("page loaded.");
	}
	
	public static void SearchForEthereumSubreddit() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		Robot robot = new Robot();
		WebElement searchlabel = wait.until(ExpectedConditions.elementToBeClickable(By.id(searchbar)));
		searchlabel.sendKeys("ethereum");	
		robot .keyPress(KeyEvent.VK_ENTER);
		System.out.println("searching for 'ethereum' subreddit...");
		Thread.sleep(3000);
	}


	public static void SelectEthereumSubreddit() {
		// TODO Auto-generated method stub
		WebElement subreddit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='r/ethereum']")));
		subreddit.click();
		System.out.println("opening the 'ethereum' subreddit...");
	}


	public static void PerformingLogin() {
		// TODO Auto-generated method stub
		System.out.println("Performing login operation... opening the"+loginpageurl);
		driver.get(loginpageurl);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginfield)));  
		driver.findElement(By.xpath(loginfield)).sendKeys(userlogin);
		driver.findElement(By.id(passwordfield)).sendKeys(userpswd);
		driver.findElement(By.xpath(loginbutton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("USER_DROPDOWN_ID")));
		System.out.println("User logged in successfully.");
	}


	public static void DownOrUpvotingThePost() {
		// TODO Auto-generated method stub
		String upvotestyle = driver.findElement(By.cssSelector("[aria-label*='upvote']")).getAttribute("aria-pressed");
		
		WebElement downvote = driver.findElement(By.cssSelector("[aria-label*='downvote']"));
		WebElement upvote = driver.findElement(By.cssSelector("[aria-label*='upvote']"));
		
	    if (upvotestyle.equals("true"))	{	
	    	downvote.click();
	    	System.out.println("Post was upvoted previously - downvote has been made.");	 	
			}
		    else {
		    	upvote.click();
			System.out.println("Post was either downvoted or not voted at all - upvote has been made.");	
		    }
	}


	public static void OpenTopPostAndGetTitle() {
		// TODO Auto-generated method stub
		WebElement topPost = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h2.s1ua9il2-0")));
		topPost.click();
		System.out.println("Top post title is: "+topPost.getText());
	}


	public static void Quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	
}

