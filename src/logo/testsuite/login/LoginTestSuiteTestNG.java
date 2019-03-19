package logo.testsuite.login;

import org.testng.annotations.Test;

import logo.log.SelLogger;

public class LoginTestSuiteTestNG {
	private static final SelLogger logger = SelLogger.getLogger(LoginTestSuiteTestNG.class);  //加载Junit类的日志信息
	private LoginTestSuiteJunit loginTestSuite = new LoginTestSuiteJunit();  //创建登录JUnit的类并初始化
	
	@Test(groups={"login"})
	public void Login_phone_TestCase_01() throws Exception {
		loginTestSuite.setUp();  //登录用例初始化
		loginTestSuite.Login_TestCase_01();  //登录用例测试
		loginTestSuite.tearDown();  //登录用例清理环境
	}

}
