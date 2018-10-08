package RumbleFishPackage;

import java.awt.AWTException;


public class TestTask {
	public static void main(String[] args) throws AWTException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	
	RumbleFish_Properties.LaunchChromeAndOpenRedditPage();
	//Open the website https://www.reddit.com/	
	
	//Search for a subreddit called "ethereum"
	RumbleFish_Properties.SearchForEthereumSubreddit();
	
	//selecting the ethereum subreddit
	RumbleFish_Properties.SelectEthereumSubreddit();
	
	//Opening the top post and getting its title
	RumbleFish_Properties.OpenTopPostAndGetTitle();
	
	//Perform a login
	RumbleFish_Properties.PerformingLogin();

	//downvoting the post (or upvoting if required)	
	RumbleFish_Properties.DownOrUpvotingThePost();

	}
}

