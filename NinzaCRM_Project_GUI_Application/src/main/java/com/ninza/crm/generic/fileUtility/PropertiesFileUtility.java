package com.ninza.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility
{
	
	public Properties loadProperyFile(String file) throws IOException
	{
		FileInputStream fis=new FileInputStream(file);
		Properties propeties=new Properties();
		propeties.load(fis);
		return propeties;
	}

	public String getDataFromPropertiesFile(Properties properties,String key) throws IOException
	{
		properties.getProperty(key);
		String value=properties.getProperty(key);
		return value;
	}

}
