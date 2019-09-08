package info2soft.qa.auto.dataobject;

public class CopyRule {

	public CopyRule(String name, String srcNode, String backupNode, 
			       String srcDir, String backupDir, String mapType) {
		this.name = name;
		this.srcNode = srcNode;
		this.backupNode = backupNode;
		this.srcDir = srcDir;
		this.backupDir = backupDir;
		this.mapType = mapType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrcNode() {
		return srcNode;
	}
	public void setSrcNode(String srcNode) {
		this.srcNode = srcNode;
	}
	public String getBackupNode() {
		return backupNode;
	}
	public void setBackupNode(String backupNode) {
		this.backupNode = backupNode;
	}
	public String getSrcDir() {
		return srcDir;
	}
	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}
	public String getBackupDir() {
		return backupDir;
	}
	public void setBackupDir(String backupDir) {
		this.backupDir = backupDir;
	}
	
	public String getMapType() {
		return mapType;
	}
	
	private String name;
	private String srcNode;
	private String backupNode;
	private String srcDir;
	private String backupDir;
	private String mapType;
}
