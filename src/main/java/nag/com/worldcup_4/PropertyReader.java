package nag.com.worldcup_4;

import java.io.*;
import java.util.*;


public class PropertyReader {
	 
    private Properties prop;

    private void loadProps(String propertyFile) throws FileNotFoundException,IOException {
           File cfgfile = new File(propertyFile);
           if (cfgfile.exists()) {
                  FileInputStream propin = new FileInputStream(cfgfile);
                  prop.load(propin);
           }
    }
    public String readProperty(String propkey) {           
           return prop.getProperty(propkey);
    }
    
	public HashMap<String, String> getProperties(String propertyPath) throws FileNotFoundException, IOException {
		prop=new Properties();  
		HashMap<String, String> map = new HashMap<String, String>();
		loadProps(propertyPath);
       	Set<Object> keys = prop.keySet();
	   	for(Object k:keys){
	   		String key = (String)k;
	   		map.put(key, (String)prop.getProperty(key));
	   	}
		return map;
	}
	
} 



