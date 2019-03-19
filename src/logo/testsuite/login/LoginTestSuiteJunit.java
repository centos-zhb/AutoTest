package logo.testsuite.login;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import log.module.BrowserDriver;
import log.module.FileExcel;
import log.module.Login;
import log.module.PublicModule;
import log.module.SiteUrl;
import logo.log.SelLogger;

public class LoginTestSuiteJunit {
	private static final SelLogger logger = SelLogger.getLogger(LoginTestSuiteJunit.class);
	private WebDriver browser;  //创建浏览器对象
	private String indexUrl,memberUrl,baseitemUrl;  //创建URL字符对象
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	FileExcel f = new FileExcel();  //创建Excel文件操作对象并初始化
	PublicModule p = new PublicModule();  //创建公共类对象并初始化
	BrowserDriver browserDriver = new BrowserDriver();  //创建浏览器驱动对象并初始化
	SiteUrl siteUrl = new SiteUrl();  //创建URL对象并初始化
	
	@BeforeClass
	public static void setUpBefore() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		browser = browserDriver.browser();  //初始化，启动Chrome浏览器
		indexUrl = siteUrl.indexUrl();  //赋值默认输入的首页URL
		memberUrl = siteUrl.memberUrl();  //赋值默认输入的用户页URL
		baseitemUrl= siteUrl.itemUrl();  //赋值默认输入的单品页URL
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //浏览器超时等待为30s
	}
	
	@After
	public void tearDown() throws Exception{
		browser.quit();  //清理环境，并退出关闭浏览器
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void Login_TestCase_01() {               //登录用例
		logger.log("Login start...");  //打印开始登录日志
		browser.get(memberUrl);        //启动浏览器并输入默认URL
		Login login = new Login(browser);  //创建登录的类调用登录类初始化
		login.userName(f.username());  //输入用户名
		login.passWord(f.password());  //输入密码方法
		login.clickLoginButton();  //单击登录按钮
		try {						//异常处理
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		login.checkResult();    //校验是否登录成功
		logger.log("...login end"+"\r\n"); //打印结束登录日志
	}

}
