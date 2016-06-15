package crazyjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ExtendReader {

	public static void main(String[] args) throws IOException {
		File file = new File("F:\\cs.txt");
		FileReader fr = new FileReader(file);
		BufferedReader buf = new BufferedReader(fr);
		EnReader efr = new EnReader(buf);
		SemiReader sfr = new SemiReader(efr);
		QuoReader qfr = new QuoReader(sfr);
		String line = null;
		while((line = qfr.readLine())!=null)
		{
			System.out.println(line);
		}
		qfr.close();
	}
}

class EnReader extends BufferedReader
{
    private int count = 1;
    BufferedReader buff;
	public EnReader(BufferedReader file) throws FileNotFoundException {
		super(file);
		this.buff = file;
	}
	@Override
	public String readLine() throws IOException {
		String line = buff.readLine();
		if(line != null)
		{
			line = count + " " + line;
			count++;
		}
		return line;
	}	
}

class SemiReader extends BufferedReader
{
	BufferedReader buff;
	public SemiReader(BufferedReader in) {
		super(in);
		this.buff = in;
	}
	@Override
	public String readLine() throws IOException {
		String line = buff.readLine();
		if(line != null)
		{
			line = line + ";";
		}
		return line;
	}
}

class QuoReader extends BufferedReader
{
	BufferedReader buff;
	public QuoReader(BufferedReader in){
		super(in);
		this.buff = in;
	}
	@Override
	public String readLine() throws IOException {
		String line = buff.readLine();
		if(line != null)
		{
			line = "\""+ line + "\"";
		}
		return line;
	}
	
}
