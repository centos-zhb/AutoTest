package logo.testsuite.login;

import org.testng.annotations.Test;

import logo.log.SelLogger;

public class LoginTestSuiteTestNG {
	private static final SelLogger logger = SelLogger.getLogger(LoginTestSuiteTestNG.class);  //����Junit�����־��Ϣ
	private LoginTestSuiteJunit loginTestSuite = new LoginTestSuiteJunit();  //������¼JUnit���ಢ��ʼ��
	
	@Test(groups={"login"})
	public void Login_phone_TestCase_01() throws Exception {
		loginTestSuite.setUp();  //��¼������ʼ��
		loginTestSuite.Login_TestCase_01();  //��¼��������
		loginTestSuite.tearDown();  //��¼����������
	}

}
