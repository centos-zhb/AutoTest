package log.module;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import logo.log.SelLogger;

public class PublicModule {
	private static final SelLogger logger = SelLogger.getLogger(PublicModule.class);
	
	//����ID�ȴ�ҳ��Ԫ��
	public void waitForPageLoadByID(final String ID,WebDriver browser) {
		try {
			WebDriverWait wait = new WebDriverWait(browser, 10);  //�������ʱ�ȴ�ʱ������Ϊ10s
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id(ID));
				}
			});
			if (null == wait) {
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);  //��ʱʱ�Զ���������ͼƬ
				browser.quit();  //�˳������
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //δ����ҳ��ʱ�Զ���������ͼƬ
			browser.quit();
		}
	}
	
	//����linkText�ȴ�ҳ��Ԫ��
	public void waitForPageLoadBylinkText(final String ID,WebDriver browser) {
		try {
			WebDriverWait wait = new WebDriverWait(browser, 10);  //�������ʱ�ȴ�ʱ������Ϊ10s
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.linkText(ID));
				}
			});
			if (null == wait) {
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //��ʱʱ�Զ���������ͼƬ
				browser.quit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //δ����ҳ��ʱ�Զ���������ͼƬ
			browser.quit();
		}
	}
	
	//����title�л��´���
	public boolean switchToWindow_Title(WebDriver driver,String windowTitle) {
		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();  //��ȡ��ǰ���ھ��
			Set<String> handles = driver.getWindowHandles();
			for(String s:handles) {
				if (s.equals(currentHandle)) {
					continue;
				} else {
					driver.switchTo().window(s);
					//�����´��ڵı���Title�жϣ�����������־Ϊtrue���л��ɹ�
					if (driver.getTitle().contains(windowTitle)) {
						flag = true;
						break;
					} else {
						continue;
					}
				}
			}
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
			//����������´��ڵı��⣬���ӡ�쳣����־Ϊfalse��û���ҵ���Ĵ���
			System.out.println("Window: "+windowTitle+"cound not find!!!" + e.fillInStackTrace());
			flag=false;
		}
		return flag;
	}
	
	//����URL�л��´���
		public boolean switchToWindow_Url(WebDriver driver,String windowUrl) {
			boolean flag = false;
			try {
				String currentHandle = driver.getWindowHandle();  //��ȡ��ǰ���ھ��
				Set<String> handles = driver.getWindowHandles();
				for(String s:handles) {
					if (s.equals(currentHandle)) {
						continue;
					} else {
						driver.switchTo().window(s);
						//�����´��ڵ�URL�жϣ�����������־Ϊtrue���л��ɹ�
						if (driver.getTitle().contains(windowUrl)) {
							flag = true;
							break;
						} else {
							continue;
						}
					}
				}
			} catch (NoSuchWindowException e) {
				// TODO: handle exception
				//����������´��ڵ�URL�����ӡ�쳣����־Ϊfalse��û���ҵ���Ĵ���
				System.out.println("Window: "+windowUrl+"cound not find!!!" + e.fillInStackTrace());
				flag=false;
			}
			return flag;
		}

	//��������
	private void CaptureScreenshot(String fileName, WebDriver driver) {
		// TODO Auto-generated method stub
		String dirName = "test-output/screenshot";  //����������ļ�Ŀ¼
		if (!(new File(dirName).isDirectory())) {
			new File(dirName).mkdir();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");  //ʱ���ʽ��
		String time = sdf.format(new Date());
		TakesScreenshot tsDriver = (TakesScreenshot)driver;
		File image = new File(dirName + File.separator + time + "_" + fileName + ".png");  //���������ͼƬ����
		tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	}

}
