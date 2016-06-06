package crazyjava;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.*;
import static java.lang.System.out;


public class StaImport {

	public static void sum(int... arr)
	{
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		out.println(sum);
		out.println(arr.length);
	}
	public static void main(String[] args) {
		//for-each circle bases on iterable;static import;
		/*ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.add(5);
        aa.add(7);
        aa.add(3);
        aa.add(4);
        
        sort(aa);
        out.println(aa);
        out.println("Find position: "+binarySearch(aa, 7));
        
        HashMap<String,String> ab = new HashMap<String, String>();
        ab.put("young", "13");
        ab.put("older", "22");
        ab.put("fort", "44");
        
        Set<Map.Entry<String, String>> en = ab.entrySet();
        for(Map.Entry<String, String> cc : en)
        {
        	out.println(cc.getKey()+" "+cc.getValue());
        }
        
        HashSet<Integer> ac = new HashSet<Integer>();
        ac.add(5);
        ac.add(7);
        ac.add(3);
        ac.add(6);
        for(Integer cc:ac)
        {
        	out.println(cc);
        }     */
		
		//create a class implements iterable
		Mylist myl = new Mylist();
		myl.add(1);
		myl.add(2);
		for(Integer i:myl)
		{
			out.println(i);
		}
		
		//unfixed number of parameters
		sum(1,2,3,4,5,6);
		
		//package type vs basic type
		String s = "101010101";
		int x = Integer.parseInt(s,2);
		out.println(x);
		
		int y = 343;
		out.println("y="+Integer.toBinaryString(y));
		
		Integer a = 10;
		Integer b = 10;
		out.println("a equals to b?"+(a==b));
	}
}

class Mylist implements Iterable<Integer>
{
	int[] arr = new int[10];
	int index;
	
	public void add(int x)
	{
		arr[index++]=x;
	}
	
	public int getSize(int arr[])
	{
		return index;
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){
            int cursor;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return cursor<index;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return arr[cursor++];
			}	
		};			
	}
}
