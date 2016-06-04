package crazyjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColnArr {

	public static void main(String[] args) {
	    ArrayList<Integer> aa = new ArrayList<Integer>();
	    for(int i=-5;i<=5;i++)
	    {
	    	aa.add(i*i);
	    }
	    System.out.println(aa);
	    Collections.sort(aa);
	    System.out.println(aa);
	    System.out.println(Collections.max(aa));
	    System.out.println(Collections.binarySearch(aa, 4));
	    
	    
	    Integer[] arr = {10,2,3,4,5};
	    Integer[] arr2 =Arrays.copyOf(arr, 5);
	    Integer[] arr3 =Arrays.copyOfRange(arr, 1, 3);
	    List<Integer> ll = Arrays.asList(arr);
	    System.out.println(Arrays.toString(arr2)+" "+Arrays.toString(arr3)+" "+ll);
	    System.out.println(Arrays.equals(arr,arr2));
	}

}
