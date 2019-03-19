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
	public static WebElement loginnameinputbox;  //����һ������id�жϵ�Ԫ�ظ�ֵΪ��loginname��
	
	@FindBy(how=How.ID,using="loginpwd")
	public static WebElement loginpwdinputbox;  //����һ������id�жϵ�Ԫ�ظ�ֵΪ��loginpwd��
	
	@FindBy(how=How.ID,using="btn-login")
	public static WebElement loginbtn;  //����һ������id�жϵ�Ԫ�ظ�ֵΪ��btn-login��
	
	@FindBy(how=How.LINK_TEXT,using="�˳�")
	public static WebElement loginResult;  //����һ������linkText�жϵ�Ԫ�ظ�ֵΪ���˳���
	
	public Login(WebDriver driver){
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 120);
		PageFactory.initElements(finder, this);
		driver.manage().window().maximize();  //�����ҳ��Ĭ�����
	}
	
	public String userName(String userNameTxt) {
		loginnameinputbox.clear();  //����ı���Ĭ��ֵ
		loginnameinputbox.sendKeys(userNameTxt);  //�����û���
		return userNameTxt;
	}
	
	public String passWord(String userPwdTxt) {
		loginpwdinputbox.clear();  //����ı���Ĭ��ֵ
		loginpwdinputbox.sendKeys(userPwdTxt);  //��������
		return userPwdTxt;
	}
	
	public void clickLoginButton() {
		p.waitForPageLoadByID("btn-login", driver);   //����Ԫ��id�ȴ���¼��ť�������ʱ�����
		loginbtn.click();  //�����¼��ť
	}
	
	public void checkResult() {
		//������ԣ�����link-text�ж��Ƿ����"�˳�"��������˵����¼�ɹ�����������ʧ��
		Assert.assertEquals(loginResult.isDisplayed(), true);
	}

}
