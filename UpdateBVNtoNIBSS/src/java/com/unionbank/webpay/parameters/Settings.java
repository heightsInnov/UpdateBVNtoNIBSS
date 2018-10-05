package com.unionbank.webpay.parameters;


import java.io.*;
import java.util.Properties;
import java.util.jar.JarFile;
import org.apache.log4j.Logger;

public class Settings
{
	private static Settings uniqueInstance = null;
	private Properties props;
	private static String configFileName = "ubnwebpay.properties";
	private static Logger logger = Logger.getLogger(Settings.class);

	private Settings(String s)
	{
		props = null;
		logger = Logger.getLogger(getClass().getName());
		props = new Properties();
		myLoad(s);
	}

	private synchronized void myLoad(String s)
	{
		try
		{
			String s1 = "ubnwebpay.properties";
			if(s != null && !s.equals(""))
			{
				logger.debug("file name not empty:" + s);
				String s2 = s;
				logger.debug("config file name:" + s2);
				FileInputStream fileinputstream = new FileInputStream(new File(s2));
				props.load(fileinputstream);
				fileinputstream.close();
			}
                        else
			{
				logger.debug("file name empty");
				String s3 = getClass().getClassLoader().getResource("com/unionbank/webpay/parameters/ubnwebpay.properties").toString().replaceAll("%20", " ").replaceAll("file:/", "/");
				if(s3.charAt(2) == ':')
					s3 = s3.substring(1);
				if(s3.startsWith("jar:"))
				{
					logger.debug("jar file");
					int i = s3.indexOf("!/");
					s3 = s3.substring(4, i);
					logger.debug("file name:" + s3);
					JarFile jarfile = new JarFile(s3);
					props.load(jarfile.getInputStream(jarfile.getEntry("com/unionbank/webpay/parameters/ubnwebpay.properties")));
				}
                                else
				{
					logger.debug("config file name:" + s3);
					FileInputStream fileinputstream1 = new FileInputStream(new File(s3));
					props.load(fileinputstream1);
					fileinputstream1.close();
				}
			}
		}
		catch(IOException ioexception)
		{
			logger.debug("failed load properties due to : " + ioexception);
		}
	}

	public static synchronized Settings getInstance(String s)
	{
		if(uniqueInstance == null)
			uniqueInstance = new Settings(s);
		return uniqueInstance;
	}

	public synchronized String getProperty(String s)
	{
		return props.getProperty(s);
	}

	public synchronized void setProperty(String s, String s1)
	{
		try
		{
			if(s1 == null)
			{
				logger.debug("Key=" + s + ", Value=" + s1);
				s1 = "Empty";
			}
			props.setProperty(s, s1);
			FileOutputStream fileoutputstream = new FileOutputStream(configFileName);
			props.store(fileoutputstream, "Settings");
		}
		catch(IOException ioexception)
		{
			logger.debug("failed load properties due to : " + ioexception);
		}
	}

}