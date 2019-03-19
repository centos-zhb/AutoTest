package log.module;

public class SiteUrl {
	private String indexUrl;  //定义首页URL私有变量
	private String memberUrl;  //定义用户页URL私有变量
	private String itemUrl;  //定义单品页URL私有变量
	
	//首页
	public String indexUrl() {
		indexUrl = "http://www.aolaigo.com";  //首页URL
		return indexUrl;
	}
	
	//用户登录页
	public String memberUrl() {
		memberUrl="http://member.aolaigo.com/login.aspx";  //用户登录页URL
		return memberUrl;
	}
	
	//单品页
	public String itemUrl() {
		itemUrl="http://item.aolaigo.com";
		return itemUrl;
	}

}
