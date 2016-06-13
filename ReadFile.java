package crazyjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
	static File file = new File("F:\\cs\\cs4.txt"); 
	
	public static void main(String[] args) throws IOException
	{
		readTest4();
	}
	
	public static void readTest() throws IOException
	{
		 FileInputStream finput = new FileInputStream(file);
		 int content=finput.read();
		 System.out.println((char)content);
		 finput.close();
	}
	
	public static void readTest2() throws IOException
	{
		 FileInputStream finput = new FileInputStream(file);
		 int content=0;
		 while((content=finput.read())!=-1){
		 System.out.print((char)content);
		 }
		 finput.close();
	}
	
	public static void readTest3() throws IOException
	{
		FileInputStream finput = new FileInputStream(file);
		byte[] buf = new byte[50];
		int length = finput.read(buf);
		String str = new String(buf,0,length);
		System.out.print(str);
		finput.close();
	}
	
	public static void readTest4() throws IOException
	{
		FileInputStream finput = new FileInputStream(file);
		byte[] buf = new byte[5];
		int length = 0;
		while((length = finput.read(buf))!=-1){
		String str = new String(buf,0,length);
		System.out.print(str);
		}
		finput.close();
	}

}
