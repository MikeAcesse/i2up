package SeleniumProject.TestImooc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	private Properties prop;
	private String filepath;
	/**
	 * 构造函数
	 * @param filePath
	 */
    public ProUtil(String filePath) {
		this.filepath = filePath;
		this.prop =readProperties();
	}
    /**
     * 读取配置文件
     * @throws Exception 
     * 
     */
    public Properties readProperties(){
    	Properties properties = new Properties();
    	
		try {
			InputStream inputStream = new FileInputStream(filepath);
			BufferedInputStream in = new BufferedInputStream(inputStream);
			properties.load(in);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return properties;
    	
    	
    }
    /**
     * 获取值
     * @param key
     */
      public  String  getPro(String key) {
    	 if(prop.containsKey(key)){
    		 String username = prop.getProperty(key);
    		 return username;
    	 }else {
			System.out.println("你获取keyd的值不在");
			return "";
		}
    
    	 
      }
    
}
