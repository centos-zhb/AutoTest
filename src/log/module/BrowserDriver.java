package log.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {  //浏览器驱动的类
	private WebDriver browser;  //创建浏览器对象
	
	public WebDriver browser() {
		browser = new ChromeDriver();  //浏览器对象赋值给Chrome浏览器的驱动
		return browser;
	}

}
