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
	
	//根据ID等待页面元素
	public void waitForPageLoadByID(final String ID,WebDriver browser) {
		try {
			WebDriverWait wait = new WebDriverWait(browser, 10);  //浏览器超时等待时间设置为10s
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id(ID));
				}
			});
			if (null == wait) {
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);  //超时时自动截屏保存图片
				browser.quit();  //退出浏览器
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //未发现页面时自动截屏保存图片
			browser.quit();
		}
	}
	
	//根据linkText等待页面元素
	public void waitForPageLoadBylinkText(final String ID,WebDriver browser) {
		try {
			WebDriverWait wait = new WebDriverWait(browser, 10);  //浏览器超时等待时间设置为10s
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.linkText(ID));
				}
			});
			if (null == wait) {
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //超时时自动截屏保存图片
				browser.quit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID", browser);  //未发现页面时自动截屏保存图片
			browser.quit();
		}
	}
	
	//根据title切换新窗口
	public boolean switchToWindow_Title(WebDriver driver,String windowTitle) {
		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();  //获取当前窗口句柄
			Set<String> handles = driver.getWindowHandles();
			for(String s:handles) {
				if (s.equals(currentHandle)) {
					continue;
				} else {
					driver.switchTo().window(s);
					//根据新窗口的标题Title判断，如果存在则标志为true，切换成功
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
			//如果不存在新窗口的标题，则打印异常，标志为false，没有找到则改窗口
			System.out.println("Window: "+windowTitle+"cound not find!!!" + e.fillInStackTrace());
			flag=false;
		}
		return flag;
	}
	
	//根据URL切换新窗口
		public boolean switchToWindow_Url(WebDriver driver,String windowUrl) {
			boolean flag = false;
			try {
				String currentHandle = driver.getWindowHandle();  //获取当前窗口句柄
				Set<String> handles = driver.getWindowHandles();
				for(String s:handles) {
					if (s.equals(currentHandle)) {
						continue;
					} else {
						driver.switchTo().window(s);
						//根据新窗口的URL判断，如果存在则标志为true，切换成功
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
				//如果不存在新窗口的URL，则打印异常，标志为false，没有找到则改窗口
				System.out.println("Window: "+windowUrl+"cound not find!!!" + e.fillInStackTrace());
				flag=false;
			}
			return flag;
		}

	//截屏方法
	private void CaptureScreenshot(String fileName, WebDriver driver) {
		// TODO Auto-generated method stub
		String dirName = "test-output/screenshot";  //截屏保存的文件目录
		if (!(new File(dirName).isDirectory())) {
			new File(dirName).mkdir();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");  //时间格式化
		String time = sdf.format(new Date());
		TakesScreenshot tsDriver = (TakesScreenshot)driver;
		File image = new File(dirName + File.separator + time + "_" + fileName + ".png");  //截屏保存的图片名称
		tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	}

}
