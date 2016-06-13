package crazyjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadnWriteFile {
	static File file = new File("F:\\cs\\cs4.txt"); 
	static File wfile = new File("F:\\cs4.txt");
	
	public static void main(String[] args) throws IOException
	{
		copyTest();
		copyTest2();
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
	//add exception handling method
	public static void readTest4()
	{
		FileInputStream finput = null;
		try{
			finput = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int length = 0;
			while((length = finput.read(buf))!=-1){
			String str = new String(buf,0,length);
			System.out.print(str);
			}
		}catch(Exception e){
			System.out.println("error in reading");
			throw new RuntimeException(e);
		}finally{
			try {
				if(finput!=null)
				{
					finput.close();
					System.out.println("closed successfully");
				}
			} catch (IOException e) {
				System.out.println("failed in closing");
				throw new RuntimeException(e);
			}
			
		}
		
	}
	
	public static void writeTest() throws IOException
	{
		FileOutputStream foutput = new FileOutputStream(wfile,true);
		foutput.write("abc".getBytes(),0,2);
		foutput.close();
	}
	
	public static void copyTest()
	{
		long start = System.currentTimeMillis();
		long mid = 0;
		File src = new File("F:\\ff\\930SAWNU\\id.JPG");
		File dst = new File("F:\\ff\\6.jpg");
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try
		{
			fin = new FileInputStream(src);
			fout = new FileOutputStream(dst);
			byte[] buf = new byte[1024*8];
			int length=0;
			while((length=fin.read(buf))!=-1)
			{
				mid = System.currentTimeMillis();
				fout.write(buf, 0, length);
			}
		}catch(Exception e)
		{
			System.out.println("failed in reading");
			throw new RuntimeException(e);
		}finally
		{
			try {
				if(fout!=null)
				{
					fout.close();
				}
				System.out.println("Output stream closed");
			} catch (IOException e) {
				System.out.println("Failed in closing Output");
				throw new RuntimeException(e);
			}finally
			{
				try{
					if(fin!=null)
					{
						fin.close();	
					}
					System.out.println("Input stream closed");
				}catch(IOException e)
				{
					System.out.println("Failed in closing Input");
					throw new RuntimeException(e);
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+" "+ (mid-start));
	}
	
	public static void copyTest2() throws IOException
	{
		long start = System.currentTimeMillis();
		long mid=0;
		File src = new File("F:\\ff\\930SAWNU\\id.JPG");
		File dst = new File("F:\\ff\\7.jpg");
		FileInputStream srcf = new FileInputStream(src);
		FileOutputStream dstf = new FileOutputStream(dst);
		BufferedInputStream srcb = new BufferedInputStream(srcf);
		BufferedOutputStream desb = new BufferedOutputStream(dstf);
		int content = 0;
		while((content=srcb.read())!=-1)
		{
			mid = System.currentTimeMillis();
			desb.write(content);
		}
		desb.close();
		srcb.close();
		long end = System.currentTimeMillis();
		System.out.println(end-start+" "+ (mid-start));
	}
}
