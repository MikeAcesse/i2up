package info2soft.qa.auto.dataobject;

public class Node {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCcIp() {
		return ccIp;
	}
	public void setCcIp(String ccIp) {
		this.ccIp = ccIp;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDataIp() {
		return dataIp;
	}
	public void setDataIp(String dataIp) {
		this.dataIp = dataIp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Node(String name, String ccIp, String port, String dataIp, String user, String pwd, String note) {
		this.name = name;
		this.ccIp = ccIp;
		this.port = port;
		this.dataIp = dataIp;
		this.user = user;
		this.pwd = pwd;
		this.note = note;
	}

	private String name;
	private String ccIp;
	private String port;
	private String dataIp;
	private String user;
	private String pwd;
	private String note;

}
