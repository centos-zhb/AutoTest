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
	private WebDriver browser;  //�������������
	private String indexUrl,memberUrl,baseitemUrl;  //����URL�ַ�����
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	FileExcel f = new FileExcel();  //����Excel�ļ��������󲢳�ʼ��
	PublicModule p = new PublicModule();  //������������󲢳�ʼ��
	BrowserDriver browserDriver = new BrowserDriver();  //����������������󲢳�ʼ��
	SiteUrl siteUrl = new SiteUrl();  //����URL���󲢳�ʼ��
	
	@BeforeClass
	public static void setUpBefore() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		browser = browserDriver.browser();  //��ʼ��������Chrome�����
		indexUrl = siteUrl.indexUrl();  //��ֵĬ���������ҳURL
		memberUrl = siteUrl.memberUrl();  //��ֵĬ��������û�ҳURL
		baseitemUrl= siteUrl.itemUrl();  //��ֵĬ������ĵ�ƷҳURL
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //�������ʱ�ȴ�Ϊ30s
	}
	
	@After
	public void tearDown() throws Exception{
		browser.quit();  //�����������˳��ر������
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void Login_TestCase_01() {               //��¼����
		logger.log("Login start...");  //��ӡ��ʼ��¼��־
		browser.get(memberUrl);        //���������������Ĭ��URL
		Login login = new Login(browser);  //������¼������õ�¼���ʼ��
		login.userName(f.username());  //�����û���
		login.passWord(f.password());  //�������뷽��
		login.clickLoginButton();  //������¼��ť
		try {						//�쳣����
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		login.checkResult();    //У���Ƿ��¼�ɹ�
		logger.log("...login end"+"\r\n"); //��ӡ������¼��־
	}

}
