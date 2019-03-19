package logo.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class SelLogger {
	private static Logger logger = null;
	private static SelLogger logg = null;
	public static SelLogger getLogger(Class<?>T) {
		if (logger == null) {
			Properties props = new Properties();
			try {
				// 根据log4级日志配置文件读取日志信息
				InputStream is = new FileInputStream("src//logo//log//log4j.properties");
				props.load(is);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			PropertyConfigurator.configure(props);
			logger = Logger.getLogger(T);
			logg = new SelLogger();
		}
		return logg;
	}
	
	//重写logger方法
	public void log(String msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //日志中日期格式化
		Calendar ca = Calendar.getInstance();
		logger.info(msg);
		Reporter.log("Reporter:" + sdf.format(ca.getTime()) + "===>" + msg);
	}
	
	
	//debug级别日志
	public void debug(String msg) {
		logger.debug(msg);
	}
	
	//warn级别日志
	public void warn(String msg) {
		logger.warn(msg);
		Reporter.log("Reporter:" + msg);
	}
	
	//error级别日志
	public void error(String msg) {
		logger.error(msg);
		Reporter.log("Reporter:" + msg);
	}

}
