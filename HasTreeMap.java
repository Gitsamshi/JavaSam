package crazyjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class HasTreeMap {

	public static void main(String[] args) {
		HashMap<Personnel, String> aa = new HashMap<Personnel,String>(); 
		Compa comp = new Compa();
		TreeMap<Personnel, String> bb = new TreeMap<Personnel, String>(comp);
        aa.put(new Personnel(110 ,"sam","1989-03-12"), "beautiful");
        aa.put(new Personnel(120 ,"jim","1990-02-22"), "lovely");
        aa.put(new Personnel(130 ,"tom","1993-06-22"), "cute");
        aa.put(new Personnel(110 ,"jam","1997-09-22"), "adorable");
        
        bb.put(new Personnel(110 ,"sam","1989-03-12"), "beautiful");
        bb.put(new Personnel(120 ,"jim","1999-03-12"), "lovely");
        bb.put(new Personnel(130 ,"tom","1989-04-12"), "cute");
        
        System.out.println(bb);
	}

}

class Personnel implements Comparable<Personnel>{
	
	int id;
	String name;
	Date birth; 
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	public Personnel(int id, String name,String birth) {
		super();
		this.id = id;
		this.name = name;
		
		try {
			this.birth= date.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[id:"+id+" name:"+name+" birth:"+date.format(birth)+"]";
	}



	@Override
	public int hashCode() {
		return this.id;
	}



	@Override
	public boolean equals(Object obj) {
		Personnel p = (Personnel) obj;
		return this.id==p.id&&this.name.equals(p.name);
	}




	@Override
	public int compareTo(Personnel o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
}

class Compa implements Comparator<Personnel>
{

	@Override
	public int compare(Personnel o1, Personnel o2) {
		// TODO Auto-generated method stub
		return o1.birth.compareTo(o2.birth);
	}
	
}
