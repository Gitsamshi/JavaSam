package crazyjava;

import java.io.File;

public class HandleDir {

	private static File file = new File("F:\\cs");
	private static File destfile = new File("F:\\cser");
	public static void main(String[] args) {
//		listDir(file,"|--");
//		DelDir(file);
		CutDir(file,destfile);
	}
	
	public static void listDir(File file,String space)
	{
		File[] files = file.listFiles();
		System.out.println(space+file.getName());
		for(File ff:files)
		{
			if(ff.isFile())
			{
				System.out.println(space+ff.getName());
			}
			else if(ff.isDirectory())
			{
				listDir(ff,"|  "+space);
			}
		}
	}
	
	public static void DelDir(File file)
	{
		File[] files = file.listFiles();
		for(File ff:files)
		{
			if(ff.isFile())
			{
				ff.delete();
			}
			else if(ff.isDirectory())
			{
				DelDir(ff);
			}
		}
		file.delete();
	}

	public static void CutDir(File file,File dstFile)
	{
		File[] files = file.listFiles();
		File dst = new File(dstFile.getAbsolutePath(),file.getName());
		dst.mkdirs();
		for(File ff:files)
		{
			if(ff.isFile())
			{
				ff.renameTo(new File(dst,ff.getName()));
			}
			else if(ff.isDirectory())
			{ 
				CutDir(ff,dst);
			}
		}
		file.delete();
		
	}
}
