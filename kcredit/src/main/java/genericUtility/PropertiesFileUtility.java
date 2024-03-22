package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String toGetDataFromPropertiesFile(String url) throws IOException {
		FileInputStream fis=new FileInputStream(IconstantUtility.propertiesfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String propertyvalue = prop.getProperty(url);
		return propertyvalue;
		
	}
}
