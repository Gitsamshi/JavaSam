import java.io.File;
import java.io.IOException;


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
		File file = new File("F:\\cs.txt");
		System.out.println("Successfully created?"+file.createNewFile());
		File directory = new File("F:\\cs1.txt");
		System.out.println("Successfully created?"+directory.mkdir());
		File indir = new File("F:\\cs1.txt\\css.txt");
		System.out.println("Successfully created?"+indir.mkdirs());
		File destFile = new File("F:\\cs2.txt");
		System.out.println("Successfully renamed?"+file.renameTo(destFile));
		File destFile2 = new File("E:\\cs.txt");
		System.out.println("Successfully transferred?"+destFile.renameTo(destFile2));
		File destDir = new File("F:\\cs3.txt");
		System.out.println("Successfully renamed?"+directory.renameTo(destDir));
		
		//delete
		System.out.println("Successfully deleted?"+file.delete());
		System.out.println("Successfully deleted?"+destFile.delete());
		System.out.println("Successfully deleted?"+indir.delete());
		System.out.println("Successfully deleted?"+directory.delete());
		destFile2.deleteOnExit();
		
		//judge
		File file4 = new File("F:\\file4.txt");
		System.out.println("isFile?"+destDir.isFile());
		System.out.println("isHidden?"+destDir.isHidden());
		System.out.println("isfile?"+file4.isFile());
		System.out.println("isHidden?"+file4.isHidden());
	}

}
