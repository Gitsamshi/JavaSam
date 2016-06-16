package crazyjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class PrintStrnCode {

	public static void main(String[] args) throws Exception {
//		changeDefault();
//		RecLogFile();
//		CodingnDecoding();
		writeTest1();
		readTest1();
	}
	
	public static void changeDefault() throws IOException
	{
		File file = new File("F:\\cs.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		ps.println("I have a golden mind");
		ps.println(true);
		ps.println(new People("sam", "1202"));
		System.out.println("this is my choice");
		ps.close();
	}

	public static void RecLogFile() throws IOException
	{
		File file = new File("F:\\2016-6-16.log");
		try
		{
			String aa = null;
			System.out.println(aa.length());
		}catch(Exception e)
		{
			e.printStackTrace(new PrintStream(new FileOutputStream(file,true)));
		}

	}
	
	public static void CodingnDecoding() throws Exception
	{
		String str = "存储完成";
		byte[] buf = str.getBytes();
		String wrongstr = new String(buf,"iso8859-1");
//		System.out.println(Arrays.toString(buf));
		byte[] buf2 = wrongstr.getBytes("iso8859-1");
		System.out.println(new String(buf2,"gbk"));
		
		byte[] buf3 = str.getBytes("utf-8");
		System.out.println(Arrays.toString(buf3));
		
	}
	
	public static void ReadTest() throws IOException
	{
		InputStream in = System.in;
		InputStreamReader inputstreamreader = new InputStreamReader(in);
		BufferedReader buf = new BufferedReader(inputstreamreader);
		String buff = null;
		while((buff=buf.readLine())!=null)
		{
			System.out.println(buff);
		}
	}
	
	public static void writeTest() throws IOException
	{
		File file = new File("F:\\cs.txt");
		FileOutputStream fout = new FileOutputStream(file);
		OutputStreamWriter optWriter = new OutputStreamWriter(fout);
		optWriter.write("大家好");
		optWriter.close();
	}
	
	public static void readTest1() throws IOException
	{
		File file = new File("F:\\cs.txt");
		FileOutputStream fout = new FileOutputStream(file);
		OutputStreamWriter optWriter = new OutputStreamWriter(fout,"utf-16");
		optWriter.write("asd濂濂");
		optWriter.close();
	}
	
	public static void writeTest1() throws IOException
	{
		File file = new File("F:\\cs.txt");
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader iptreader = new InputStreamReader(fin,"gbk");
		char[] buff = new char[1024];
		int length = 0;
		while((length=iptreader.read(buff))!=-1)
		{
			System.out.println(new String(buff,0,length));
		}
		iptreader.close();
	}
}


