package log.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {  //�������������
	private WebDriver browser;  //�������������
	
	public WebDriver browser() {
		browser = new ChromeDriver();  //���������ֵ��Chrome�����������
		return browser;
	}

}
