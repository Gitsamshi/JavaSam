package crazyjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequeFile {

	public static void main(String[] args) throws IOException {
		Split();
		Merge();

	}
	
	public static void Split() throws IOException
	{
		File file = new File("F:\\open.mp3");
		File dir = new File("F:\\ff");
		FileInputStream finput = new FileInputStream(file);
		
		byte[] split = new byte[1024*1024];
		int length = 0;
		int start = 0;
		for(start = 0;(length = finput.read(split))!=-1;start++)
		{
			FileOutputStream foutput = new FileOutputStream(new File(dir,"open"+start+".mp3"));	
			foutput.write(split, 0, length);
			foutput.close();
		}
		finput.close();
	}
	
	public static void Merge() throws IOException
	{
		File dir = new File("F:\\ff");
		File file = new File("F:\\open6.mp3");
		File[] files = dir.listFiles();
		FileOutputStream foutput = new FileOutputStream(file);
		Vector<FileInputStream> vt = new Vector<FileInputStream>();
		for(int i=0;i<files.length;i++)
		{
			if(files[i].getName().matches(".+\\.mp3"))
			{
				FileInputStream finput = new FileInputStream(files[i]);
				vt.add(finput);
			}
		}		
		Enumeration<FileInputStream> e = vt.elements();
		SequenceInputStream sInput = new SequenceInputStream(e);
		byte[] bt = new byte[1024*8];
		int length = 0;
		while ((length=sInput.read(bt))!=-1)
		{
			foutput.write(bt, 0, length);
		}
		sInput.close();
		foutput.close();
	}

}

