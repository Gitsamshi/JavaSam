package crazyjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesUsage {

	public static void main(String[] args) throws IOException {
//		writeProperty();
//		readProperty();
		File file = new File("F:\\gameproperties.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		String count = properties.getProperty("count");
		
		int num = 0;
		if(count!=null)
		{
			num = Integer.parseInt(count);
		}
		if(num>=3)
		{
			System.out.println("Please use the authorized software");
			System.exit(0);
		}
		else
		{
			num++;
			System.out.println("The software is in its "+num+" use");
		}
		
		
		properties.setProperty("count", ""+num);
		properties.store(new FileOutputStream(file), "Runtime");
		

	}
	
	public static void writeProperty() throws IOException
	{
		Properties property = new Properties();
		property.setProperty("施展", "200");
		property.setProperty("许山多", "900");
		property.setProperty("乘车", "800");
		property.store(new FileWriter("F:\\aa.property"), "搞笑");
	}
	
	public static void readProperty() throws IOException
	{
		Properties property = new Properties();
		property.load(new FileReader("F:\\aa.property"));
		Set<Entry<Object,Object>> aa = property.entrySet();
		for(Entry<Object,Object> each: aa)
		{
			System.out.println("name:"+each.getKey()+"value:"+each.getValue());
		}
	}

}
