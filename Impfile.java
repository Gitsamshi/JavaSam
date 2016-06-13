import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Impfile {

	public static void main(String[] args) throws IOException {
		
	   //File's constructor method
       /*File  file = new File("F:"+File.separator+"ff");
       File parent = new File("F:\\");
       File child = new File(parent,"a.txt");
       
       System.out.println("exists?"+file.exists());
       System.out.println("exists?"+child.exists());
       System.out.println("sepator?"+File.separator);*/
		
		//File's path direct or indirect
		/*File file = new File(".");
		System.out.println("current path:" + file.getAbsolutePath());
		File file1= new File("..\\..\\a.txt");
		System.out.println("exists?"+file1.exists());
		File file2= new File("src\\kk");
		System.out.println("exists?"+file2.exists());*/
		
		//create rename; rename is used as move when used between different files of disks, but it can't apply to diff directory bet disks.
//		File file = new File("F:\\cs.txt");
//		System.out.println("Successfully created?"+file.createNewFile());
//		File directory = new File("F:\\cs1.txt");
//		System.out.println("Successfully created?"+directory.mkdir());
//		File indir = new File("F:\\cs1.txt\\css.txt");
//		System.out.println("Successfully created?"+indir.mkdirs());
//		File destFile = new File("F:\\cs2.txt");
//		System.out.println("Successfully renamed?"+file.renameTo(destFile));
//		File destFile2 = new File("E:\\cs.txt");
//		System.out.println("Successfully transferred?"+destFile.renameTo(destFile2));
//		File destDir = new File("F:\\cs3.txt");
//		System.out.println("Successfully renamed?"+directory.renameTo(destDir));
		
		//delete
//		System.out.println("Successfully deleted?"+file.delete());
//		System.out.println("Successfully deleted?"+destFile.delete());
//		System.out.println("Successfully deleted?"+indir.delete());
//		System.out.println("Successfully deleted?"+directory.delete());
//		destFile2.deleteOnExit();
		
		//judge
//		File file4 = new File("F:\\file4.txt");
//		System.out.println("isFile?"+destDir.isFile());
//		System.out.println("isHidden?"+destDir.isHidden());
//		System.out.println("isfile?"+file4.isFile());
//		System.out.println("isHidden?"+file4.isHidden());
		
		//getPath,name
		/*File file = new File("F:\\cs4.txt");
		file.createNewFile();
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		System.out.println(file.getParent());
		Date date = new Date(file.lastModified());
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd, HH:mm:ss");
		System.out.println("Last modified time:"+format.format(date));*/
		
		//list,listfile,root method
		/*File[] roots = File.listRoots();
		for(File file:roots)
		{
			System.out.println(file.getPath());
		}
		
		File file = new File("F:\\ff\\930SAWNU");
		String[] filenames = file.list();
		for(String str:filenames)
		{
			System.out.println(str);
		}
		
		File[] files = file.listFiles();
		for(File ff:files)
		{
			System.out.println(ff.getName());
		}*/
		
		//file filter
		/*File file = new File("E:\\java\\crazyjava\\src");
		String[] filenames = file.list();
		for(String str:filenames)
		{
			if(str.matches(".+\\.java"))
			{
				System.out.println(str);
			}
		}
		
		File[] files = file.listFiles();
		System.out.println("Directories:");
		for(File fl: files)
		{
			if(fl.isDirectory())
			{
				System.out.println(fl.getName());
			}
		}
		System.out.println("Files:");
		for(File fl: files)
		{
			if(fl.isFile())
			{
				System.out.println(fl.getName());
			}
		}
		
		File[] filess = file.listFiles(new Myfilter());
		for(File fl:filess)
		{
			if(fl.isFile())
			System.out.println(fl.getName());
		}*/
	}
}

class Myfilter implements FilenameFilter
{

	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(".java");
	}
	
}
