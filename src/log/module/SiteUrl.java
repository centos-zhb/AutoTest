package log.module;

public class SiteUrl {
	private String indexUrl;  //������ҳURL˽�б���
	private String memberUrl;  //�����û�ҳURL˽�б���
	private String itemUrl;  //���嵥ƷҳURL˽�б���
	
	//��ҳ
	public String indexUrl() {
		indexUrl = "http://www.aolaigo.com";  //��ҳURL
		return indexUrl;
	}
	
	//�û���¼ҳ
	public String memberUrl() {
		memberUrl="http://member.aolaigo.com/login.aspx";  //�û���¼ҳURL
		return memberUrl;
	}
	
	//��Ʒҳ
	public String itemUrl() {
		itemUrl="http://item.aolaigo.com";
		return itemUrl;
	}

}
