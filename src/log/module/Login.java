package log.module;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import logo.log.SelLogger;

public class Login {
	private static final SelLogger logger = SelLogger.getLogger(Login.class);
	private WebDriver driver;
	PublicModule p = new PublicModule();
	
	@FindBy(how=How.ID,using="loginname")
	public static WebElement loginnameinputbox;  //定义一个根据id判断的元素赋值为“loginname”
	
	@FindBy(how=How.ID,using="loginpwd")
	public static WebElement loginpwdinputbox;  //定义一个根据id判断的元素赋值为“loginpwd”
	
	@FindBy(how=How.ID,using="btn-login")
	public static WebElement loginbtn;  //定义一个根据id判断的元素赋值为“btn-login”
	
	@FindBy(how=How.LINK_TEXT,using="退出")
	public static WebElement loginResult;  //定义一个根据linkText判断的元素赋值为“退出”
	
	public Login(WebDriver driver){
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 120);
		PageFactory.initElements(finder, this);
		driver.manage().window().maximize();  //浏览器页面默认最大化
	}
	
	public String userName(String userNameTxt) {
		loginnameinputbox.clear();  //清空文本框默认值
		loginnameinputbox.sendKeys(userNameTxt);  //输入用户名
		return userNameTxt;
	}
	
	public String passWord(String userPwdTxt) {
		loginpwdinputbox.clear();  //清空文本框默认值
		loginpwdinputbox.sendKeys(userPwdTxt);  //输入密码
		return userPwdTxt;
	}
	
	public void clickLoginButton() {
		p.waitForPageLoadByID("btn-login", driver);   //根据元素id等待登录按钮，如果超时则截屏
		loginbtn.click();  //点击登录按钮
	}
	
	public void checkResult() {
		//结果断言，根据link-text判断是否存在"退出"，存在则说明登录成功，否则用例失败
		Assert.assertEquals(loginResult.isDisplayed(), true);
	}

}
