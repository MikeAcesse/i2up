package info2soft.qa.auto.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import info2soft.qa.auto.dataobject.CompareRule;
import info2soft.qa.auto.dataobject.CopyRule;
import info2soft.qa.auto.dataobject.Node;
import info2soft.qa.common.configuration.AutomationClientEnvironment;

public class JsonUtil {

    public static Properties prop = new Properties();

    public static final String PROP_FILE = "/i2up.properties";
    public static final String LOCAL_PROP_FILE = "i2up.properties";
    public static String fileName = PROP_FILE;

    public static final String CENTCTL_USER = "loginUserName";
    public static final String CENTCTL_PWD = "loginPwd";  
    public static final String CENTCTL_IP = "i2upIp";
    public static final String CENTCTL_PORT = "i2upPort";    
    public static final String NODE_NAME = "node_name";
    public static final String NODE_IP = "node_ip";
    public static final String NODE_USER = "node_user";
    public static final String NODE_PASS = "node_pwd";

    public static void loadProperties() throws Exception {

        File propFile = new File(fileName);
        if (!propFile.exists()) {
            fileName = LOCAL_PROP_FILE;
        }

        try (InputStream input = new FileInputStream(fileName)) {
            prop.load(input);

            String nodeuser = JsonUtil.prop.getProperty(JsonUtil.NODE_USER);
            if( nodeuser==null || nodeuser.equals("") ) {
            	nodeuser = "root";
                JsonUtil.prop.setProperty(JsonUtil.NODE_USER,nodeuser);
                JsonUtil.saveProperties();
            }
        }
    }

	public static void loadProperties(String fileName) throws Exception {

		InputStream input = null;

		input = new FileInputStream(fileName);

		prop.load(input);
		input.close();

	}
	
    public static void saveProperties() throws Exception {
        FileOutputStream out = new FileOutputStream(fileName);
        prop.store(out, "");
    }

    public static String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static JSONObject getInfo(JSONObject accountInfo, String type, String name) throws Exception {
        for (int i = 0; i < accountInfo.getJSONArray(type).length(); i++) {
            if (accountInfo.getJSONArray(type).getJSONObject(i).get("name").equals(name)) {
                return accountInfo.getJSONArray(type).getJSONObject(i);
            }

        }
        return null;
    }

    public static JSONObject loadInfoJson(String fileName) throws Exception {

        String content = "";
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();

        while (line != null) {
            content = content + line + System.lineSeparator();

            line = reader.readLine();
        }
        reader.close();


        JSONObject a = new JSONObject(content);

        return a;

    }
    
    public static List<Node> getNodeInfo(JSONObject testData) {
		List<Node> nodes = new ArrayList<Node>();

		JSONArray testList = (JSONArray) testData.get("testList");
		for (int i = 0; i < testList.length(); i++) {
			JSONObject noteList = (JSONObject) testList.get(i);
			if (noteList.has("node")) {
				JSONArray nodeArray = noteList.getJSONArray("node");
				for (int j = 0; j < nodeArray.length(); j++) {
					JSONObject jsonObject = nodeArray.getJSONObject(j);
					nodes.add(new Node(jsonObject.getString("name"), jsonObject.getString("ccIp"),
							jsonObject.getString("port"),jsonObject.getString("dataIp"), 
							jsonObject.getString("user"),jsonObject.getString("pwd"),
							jsonObject.getString("note")));
				}
			}
		}
		return nodes;
	}

    public static List<CopyRule> getCopyRuleInfo(JSONObject testData) {
		List<CopyRule> copyRules = new ArrayList<CopyRule>();

		JSONArray testList = (JSONArray) testData.get("testList");
		for (int i = 0; i < testList.length(); i++) {
			JSONObject copyRuleList = (JSONObject) testList.get(i);
			if (copyRuleList.has("copyRule")) {
				JSONArray copyRuleArray = copyRuleList.getJSONArray("copyRule");
				for (int j = 0; j < copyRuleArray.length(); j++) {
					JSONObject jsonObject = copyRuleArray.getJSONObject(j);
					copyRules.add(new CopyRule(jsonObject.getString("name"),  jsonObject.getString("srcNode"), 
							 jsonObject.getString("backupNode"), jsonObject.getString("srcDir"), 
							 jsonObject.getString("backupDir"), jsonObject.getString("mapType")));
				}
			}
		}
		return copyRules;
	}

    public static List<CompareRule> getCompareRuleInfo(JSONObject testData) {
		List<CompareRule> compareRules = new ArrayList<CompareRule>();

		JSONArray testList = (JSONArray) testData.get("testList");
		for (int i = 0; i < testList.length(); i++) {
			JSONObject compareRuleList = (JSONObject) testList.get(i);
			if (compareRuleList.has("compareRule")) {
				JSONArray compareRuleArray = compareRuleList.getJSONArray(("compareRule"));
				for (int j = 0; j < compareRuleArray.length(); j++) {
					JSONObject jsonObject = compareRuleArray.getJSONObject(j);
					compareRules.add(new CompareRule(jsonObject.getString("name"), jsonObject.getString("srcNode"),
							jsonObject.getString("backupNode"),jsonObject.getString("srcDir"), 
							jsonObject.getString("backupDir")));
				}
			}
		}
		return compareRules;
	}
	
    public static boolean nil(String str) {
        return str == null || str.isEmpty();
    }
    
//    public static void main(String args[]) throws Exception {
//    	JSONObject testData = loadInfoJson(AutomationClientEnvironment.folders.inputData() + "TestData.json");
//    	System.out.println(testData.get("loginUserName"));
//    	System.out.println(testData.get("loginPwd"));
//    	
//    	for(Node n : getNodeInfo(testData)) {
//        	System.out.println(n.getName());
//        	System.out.println(n.getDataIp());
//    	}
//    	
//    	for(CopyRule n : getCopyRuleInfo(testData)) {
//        	System.out.println(n.getName());
//        	System.out.println(n.getSrcDir());
//    	}
//    	
//    	for(CompareRule n : getCompareRuleInfo(testData)) {
//        	System.out.println(n.getName());
//        	System.out.println(n.getSrcNode());
//    	}
//    }
}
